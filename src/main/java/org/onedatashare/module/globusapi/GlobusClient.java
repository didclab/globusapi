package org.onedatashare.module.globusapi;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import reactor.core.publisher.Mono;

public class GlobusClient {
    private static final String CONTENT_TYPE = "application/json";
    private final WebClient webClient;
    String AUTH_BASE_URL = "https://auth.globus.org/v2/oauth2";
    String AUTH_URI = "/authorize";
    String TOKEN_URI = "/token";
    String TRANSFER_BASE_URL = "https://transfer.api.globusonline.org/v0.10";
    String TRANSFER_URI = "/transfer";
    String SUBMISSION_URI = "/submission_id";
    String ENDPOINT_ACTIVATION_URI = "/endpoint/{id}/activate";
    String ENDPOINT_SEARCH_URI = "/endpoint_search";
    String ENDPOINT_DETAIL_URI = "/endpoint/{id}";
    String ENDPOINT_FILE_LIST_URI = "/endpoint/{id}/ls";
    String ENDPOINT_MKDIR_URI = "/operation/endpoint/{id}/mkdir";
    String TASK_LIST_URI = "/task_list";
    String TASK_DETAIL_URI = "/task/{id}";
    String TASK_CANCEL_URI = "/task/{id}/cancel";
    String REDIRECT_URI = "https://www.onedatashare.org/api/stork/oauth/gridftp";
    String CLIENT_ID = "6843af68-87f8-4341-bfc4-3db4b1e2d845";
    String CLIENT_SECRET = "IsqQ6AlvDCi/z5em+D6NJl2cRFq9gFt0jm9GRseQek0=";
    String SCOPE = "urn:globus:auth:scope:transfer.api.globus.org:all urn:globus:auth:scope:auth.globus.org:view_identities offline_access";
    String RESPONSE_TYPE = "code";
    private String accessToken;

    public GlobusClient() {
        this.webClient = WebClient.builder().baseUrl(this.AUTH_BASE_URL).defaultHeader("Content-Type", new String[]{"application/json"}).build();
    }

    public GlobusClient(String accessToken) {
        this.webClient = WebClient.builder().baseUrl(this.TRANSFER_BASE_URL).defaultHeader("Content-Type", new String[]{"application/json"}).defaultHeader("Authorization", new String[]{"Bearer " + accessToken}).filter(logRequest()).build();
    }

    public Mono<String> generateAuthURL() throws URISyntaxException, MalformedURLException {
        String code = RandomStringUtils.random(25, true, true);
        URIBuilder b = new URIBuilder(this.AUTH_BASE_URL + this.AUTH_URI);
        b.addParameter("client_id", this.CLIENT_ID);
        b.addParameter("scope", this.SCOPE);
        b.addParameter("response_type", "code");
        b.addParameter("redirect_uri", this.REDIRECT_URI);
        b.addParameter("state", code);
        return Mono.just(b.build().toURL().toString());
    }

    public Mono<CustomTokenResponse> getAccessToken(String authCode) {
        Map<String, String> authRequestVariables = new HashMap();
        authRequestVariables.put("redirect_uri", this.REDIRECT_URI);
        authRequestVariables.put("grant_type", "authorization_code");
        authRequestVariables.put("code", authCode);
        String encode = Base64.getEncoder().encodeToString((this.CLIENT_ID + ":" + this.CLIENT_SECRET).getBytes());
        return ((RequestBodySpec)((RequestBodySpec)this.webClient.post().uri((uriBuilder) -> {
            return uriBuilder.path(this.TOKEN_URI).queryParam("redirect_uri", new Object[]{this.REDIRECT_URI}).queryParam("code", new Object[]{authCode}).queryParam("grant_type", new Object[]{"authorization_code"}).build(new Object[0]);
        })).header("Authorization", new String[]{"Basic " + encode})).retrieve().bodyToMono(CustomTokenResponse.class);
    }

    public Mono<FileList> listFiles(String endPointId, String path, Boolean showHidden, Integer offset, Integer limit, String orderBy, String filter) {
        String uri = this.ENDPOINT_FILE_LIST_URI.replace("{id}", endPointId);
        return this.webClient.get().uri((builder) -> {
            return builder.path(uri).queryParam("path", new Object[]{path}).queryParam("show_hidden", new Object[]{String.valueOf(showHidden)}).queryParam("limit", new Object[]{String.valueOf(limit)}).queryParam("offset", new Object[]{String.valueOf(offset)}).build(new Object[0]);
        }).retrieve().bodyToMono(FileList.class);
    }

    public Mono<Result> mkdir(String endpointId, String path) {
        String uri = this.ENDPOINT_MKDIR_URI.replace("{id}", endpointId);
        MkdirRequest mkr = new MkdirRequest();
        mkr.setPath(path);
        mkr.setDataType("mkdir");
        return ((RequestBodySpec)((RequestBodySpec)this.webClient.post().uri(uri, new Object[0])).contentType(MediaType.APPLICATION_JSON).accept(new MediaType[]{MediaType.APPLICATION_JSON})).syncBody(mkr).retrieve().bodyToMono(Result.class);
    }

    private static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor((clientRequest) -> {
            System.out.println("Request: " + clientRequest.method() + " " + clientRequest.url());
            clientRequest.headers().forEach((name, values) -> {
                values.forEach((value) -> {
                    System.out.println(name + "=" + value);
                });
            });
            clientRequest.attributes().forEach((name, values) -> {
                System.out.println(name + "=" + values);
            });
            System.out.println(clientRequest.body());
            return Mono.just(clientRequest);
        });
    }

    public Mono<Task> getTaskDetail(String taskId) {
        String uri = this.TASK_DETAIL_URI.replace("{id}", taskId);
        return this.webClient.get().uri(uri, new Object[0]).retrieve().bodyToMono(Task.class);
    }

    public Mono<Result> cancelTask(String taskId) {
        String uri = this.TASK_CANCEL_URI.replace("{id}", taskId);
        return ((RequestBodySpec)this.webClient.post().uri(uri, new Object[0])).retrieve().bodyToMono(Result.class);
    }

    public Mono<Result> submitTask(TaskSubmissionRequest taskSubmissionRequest) {
        return ((RequestBodySpec)((RequestBodySpec)this.webClient.post().uri("/" + taskSubmissionRequest.getDataType(), new Object[0])).contentType(MediaType.APPLICATION_JSON).accept(new MediaType[]{MediaType.APPLICATION_JSON})).syncBody(taskSubmissionRequest).retrieve().bodyToMono(Result.class);
    }

    public Mono<Result> getJobSubmissionId() {
        return this.webClient.get().uri(this.SUBMISSION_URI, new Object[0]).retrieve().bodyToMono(Result.class);
    }

    public Mono<ActivationResult> activateEndPoint(String endPointId, String hostName, String serverDN, String userName, String password) {
        String uri = this.ENDPOINT_ACTIVATION_URI.replace("{id}", endPointId);
        ActivationRequirement proxyChainRequirement = new ActivationRequirement("proxy_chain", "delegate_proxy", "Proxy Chain", (String)null, false);
        ActivationRequirement hostRequirement = new ActivationRequirement("hostname", "myproxy", "MyProxy Server", hostName, false);
        ActivationRequirement userNameRequirement = new ActivationRequirement("username", "myproxy", "Username", userName, false);
        ActivationRequirement passwordRequirement = new ActivationRequirement("passphrase", "myproxy", "Passphrase", password, true);
        ActivationRequirement serverDNRequirement = new ActivationRequirement("server_dn", "myproxy", "Server DN", serverDN, false);
        List<ActivationRequirement> requirementList = new ArrayList();
        requirementList.add(proxyChainRequirement);
        requirementList.add(hostRequirement);
        requirementList.add(userNameRequirement);
        requirementList.add(passwordRequirement);
        requirementList.add(serverDNRequirement);
        ActivationRequest activationRequest = new ActivationRequest();
        activationRequest.setData(requirementList);
        return ((RequestBodySpec)this.webClient.post().uri(uri, new Object[0])).syncBody(activationRequest).retrieve().bodyToMono(ActivationResult.class);
    }

    public Mono<EndPoint> getEndPoint(String endPointId) {
        String uri = this.ENDPOINT_DETAIL_URI.replace("{id}", endPointId);
        return this.webClient.get().uri(uri, new Object[0]).retrieve().bodyToMono(EndPoint.class);
    }

    public Mono<EndPointList> getEndPointList(String filterScope, String offset, String limit, String searchText) {
        return this.webClient.get().uri((builder) -> {
            return builder.path(this.ENDPOINT_SEARCH_URI).queryParam("filter_scope", new Object[]{filterScope}).queryParam("offset", new Object[]{offset}).queryParam("limit", new Object[]{limit}).queryParam("filter_fulltext", new Object[]{searchText}).build(new Object[0]);
        }).retrieve().bodyToMono(EndPointList.class);
    }

    public Mono<TaskList> getTaskList(Map<String, String> filters) {
        StringBuilder filterBuilder = new StringBuilder();
        int noOfFilters = filters.size();
        int filterCounter = 0;
        Iterator var5 = filters.entrySet().iterator();

        while(var5.hasNext()) {
            Entry<String, String> filterConfig = (Entry)var5.next();
            ++filterCounter;
            String filterKey = (String)filterConfig.getKey();
            String filterValue = (String)filterConfig.getValue();
            filterBuilder.append(filterKey);
            filterBuilder.append(":");
            filterBuilder.append(filterValue);
            if (filterCounter < noOfFilters) {
                filterBuilder.append("/");
            }
        }

        return this.webClient.get().uri((builder) -> {
            return builder.path(this.TASK_LIST_URI).queryParam("filter", new Object[]{filterBuilder.toString()}).build(new Object[0]);
        }).retrieve().bodyToMono(TaskList.class);
    }
}
