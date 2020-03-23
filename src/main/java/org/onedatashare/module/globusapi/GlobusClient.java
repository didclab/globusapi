package org.onedatashare.module.globusapi;

import lombok.Setter;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


class GlobusConstants{
    public static final String CONTENT_TYPE = "application/json";
    public static final String AUTH_BASE_URL = "https://auth.globus.org/v2/oauth2";
    public static final String AUTH_URI = "/authorize";
    public static final String TOKEN_URI = "/token";
    public static final String TRANSFER_BASE_URL = "https://transfer.api.globusonline.org/v0.10";
    public static final String SUBMISSION_URI = "/submission_id";
    public static final String ENDPOINT_ACTIVATION_URI = "/endpoint/{id}/activate";
    public static final String ENDPOINT_SEARCH_URI = "/endpoint_search";
    public static final String ENDPOINT_DETAIL_URI = "/endpoint/{id}";
    public static final String ENDPOINT_FILE_LIST_URI = "/endpoint/{id}/ls";
    public static final String SCOPE = "urn:globus:auth:scope:transfer.api.globus.org:all urn:globus:auth:scope:auth.globus.org:view_identities offline_access";
}

//@Service
public class GlobusClient{
    private WebClient webClient;

    @Setter private String redirectUri = "https://127.0.0.1:8443/api/stork/oauth";
    @Setter String clientId = "6843af68-87f8-4341-bfc4-3db4b1e2d845";
    @Setter String clientSecret = "IsqQ6AlvDCi/z5em+D6NJl2cRFq9gFt0jm9GRseQek0=";
    @Setter private String accessToken;

    public GlobusClient() {
        this.webClient = WebClient.builder()
                .baseUrl(GlobusConstants.AUTH_BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, GlobusConstants.CONTENT_TYPE)
                .build();
    }

    public GlobusClient(String accessToken) {
        this.webClient = WebClient.builder()
                .baseUrl(GlobusConstants.TRANSFER_BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, GlobusConstants.CONTENT_TYPE)
                .defaultHeader("Authorization", "Bearer " + accessToken)
                .build();
    }

    public Mono<String> generateAuthURL() throws URISyntaxException, MalformedURLException {
        String code = RandomStringUtils.random(25, true, true);
        URIBuilder b = new URIBuilder(GlobusConstants.AUTH_BASE_URL + GlobusConstants.AUTH_URI);
        b.addParameter("client_id", clientId);
        b.addParameter("scope", GlobusConstants.SCOPE);
        b.addParameter("response_type", "code");
        b.addParameter("redirect_uri", redirectUri);
        b.addParameter("state", code);
        return Mono.just(b.build().toURL().toString());
    }

    public Mono<CustomTokenResponse> getAccessToken(String authCode) {
        Map<String, String> authRequestVariables = new HashMap<>();
        authRequestVariables.put("redirect_uri", redirectUri);
        authRequestVariables.put("grant_type", "authorization_code");
        authRequestVariables.put("code", authCode);
        String encode = Base64.getEncoder().encodeToString((clientId +":"+ clientSecret).getBytes());

        return webClient.post()
                .uri(uriBuilder -> uriBuilder.path(GlobusConstants.TOKEN_URI)
                        .queryParam("redirect_uri", redirectUri)
                        .queryParam("code", authCode)
                        .queryParam("grant_type", "authorization_code")
                        .build())
                .header("Authorization", "Basic " + encode)
                .retrieve()
                .bodyToMono(CustomTokenResponse.class);
    }


    public Mono<FileList> listFiles(String endPointId, String path, Boolean showHidden, Integer offset, Integer limit, String orderBy,
                                    String filter) {

        String uri = GlobusConstants.ENDPOINT_FILE_LIST_URI.replace("{id}",endPointId);
        return webClient.get()
                .uri(builder -> builder.path(uri)
                        .queryParam("path",path)
                        .queryParam("show_hidden",String.valueOf(showHidden))
                        .queryParam("limit", String.valueOf(limit))
                        .queryParam("offset", String.valueOf(offset))
                        .build())
                .retrieve()
                .bodyToMono(FileList.class);
    }

    public Mono<Result> mkdir(TaskSubmissionRequest taskSubmissionRequest, String endpointId) {
        return webClient.post()
                .uri("/operation/endpoint/" + endpointId + "/mkdir")
                .syncBody(taskSubmissionRequest)
                .retrieve()
                .bodyToMono(Result.class);
    }

    public Mono<Result> submitTask(TaskSubmissionRequest taskSubmissionRequest) {
        return webClient.post()
                .uri("/" + taskSubmissionRequest.getDataType())
                .syncBody(taskSubmissionRequest)
                .retrieve()
                .bodyToMono(Result.class);
    }

    public Mono<Result> getJobSubmissionId() {
        return webClient.get()
                .uri(GlobusConstants.SUBMISSION_URI)
                .retrieve()
                .bodyToMono(Result.class);
    }

    public Mono<ActivationResult> activateEndPoint(String endPointId, String hostName, String serverDN, String userName, String password){

        String uri = GlobusConstants.ENDPOINT_ACTIVATION_URI.replace("{id}",endPointId);

        ActivationRequirement proxyChainRequirement = new ActivationRequirement("proxy_chain", "delegate_proxy", "Proxy Chain", null, false);
        ActivationRequirement hostRequirement = new ActivationRequirement("hostname", "myproxy","MyProxy Server", hostName, false);
        ActivationRequirement userNameRequirement = new ActivationRequirement("username","myproxy", "Username", userName, false);
        ActivationRequirement passwordRequirement = new ActivationRequirement("passphrase", "myproxy", "Passphrase", password, true);
        ActivationRequirement serverDNRequirement = new ActivationRequirement("server_dn", "myproxy",  "Server DN", serverDN, false);
        List<ActivationRequirement> requirementList = new ArrayList<>();
        requirementList.add(proxyChainRequirement);
        requirementList.add(hostRequirement);
        requirementList.add(userNameRequirement);
        requirementList.add(passwordRequirement);
        requirementList.add(serverDNRequirement);
        ActivationRequest activationRequest = new ActivationRequest();
        activationRequest.setData(requirementList);
        return webClient.post()
                .uri(uri)
                .syncBody(activationRequest)
                .retrieve()
                .bodyToMono(ActivationResult.class);
    }

    public Mono<EndPoint> getEndPoint(String endPointId){

        String uri = GlobusConstants.ENDPOINT_DETAIL_URI.replace("{id}",endPointId);
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(EndPoint.class);

    }

    public Mono<EndPointList> getEndPointList(String filterScope, String offset, String limit, String searchText){

        return webClient.get()
                .uri(builder -> builder.path(GlobusConstants.ENDPOINT_SEARCH_URI)
                        .queryParam("filter_scope",filterScope)
                        .queryParam("offset",offset)
                        .queryParam("limit",limit)
                        .queryParam("filter_fulltext", searchText)
                        .build())
                .retrieve()
                .bodyToMono(EndPointList.class);
    }
}
