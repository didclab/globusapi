package org.onedatashare.module.globusapi;

import com.google.api.client.auth.oauth2.TokenResponse;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import sun.misc.BASE64Encoder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;

//@Service
public class GlobusClient {
    private static final String CONTENT_TYPE = "application/json";
    private final WebClient webClient;
    //@Value("${auth.base.url}")
    String AUTH_BASE_URL = "https://auth.globus.org/v2/oauth2";
    //@Value("$(auth.uri")
    String AUTH_URI = "/authorize";
    //@Value("${token.uri}")
    String TOKEN_URI = "/token";
    //@Value("${transfer.base.url}")
    String TRANSFER_BASE_URL = "https://transfer.api.globusonline.org/v0.10";
    //@Value("$(transfer.uri)")
    String TRANSFER_URI = "/transfer";
    //@Value("${submission.uri}")
    String SUBMISSION_URI = "/submission_id";
    //@Value("${endpoint.activation.uri}")
    String ENDPOINT_ACTIVATION_URI = "/endpoint/{id}/activate";
    //@Value("${endpoint_search.uri}")
    String ENDPOINT_SEARCH_URI = "/endpoint_search";
    //@Value("${endpoint_detail.uri}")
    String ENDPOINT_DETAIL_URI = "/endpoint/{id}";
    //@Value("${endpoint_file_list.uri}")
    String ENDPOINT_FILE_LIST_URI = "/endpoint/{id}/ls";
    //@Value("${redirect.uri}")
    String REDIRECT_URI = "https://127.0.0.1:8443/api/stork/oauth";
    //@Value("${client.id}")
    String CLIENT_ID = "6843af68-87f8-4341-bfc4-3db4b1e2d845";
    //@Value("${client.secret}")
    String CLIENT_SECRET = "IsqQ6AlvDCi/z5em+D6NJl2cRFq9gFt0jm9GRseQek0=";
    //@Value("${scope}")
    String SCOPE = "urn:globus:auth:scope:transfer.api.globus.org:all urn:globus:auth:scope:auth.globus.org:view_identities offline_access";
    //@Value("$(response.type)")
    String RESPONSE_TYPE = "code";
    private String accessToken;

    public GlobusClient() {
        this.webClient = WebClient.builder()
                .baseUrl(AUTH_BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE)
                .build();
    }

    public GlobusClient(String accessToken) {
        this.webClient = WebClient.builder()
                .baseUrl(TRANSFER_BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE)
                .defaultHeader("Authorization", "Bearer " + accessToken)
                .build();
    }

    public Mono<String> generateAuthURL() throws URISyntaxException, MalformedURLException {
        String code = RandomStringUtils.random(25, true, true);
        URIBuilder b = new URIBuilder(AUTH_BASE_URL + AUTH_URI);
        b.addParameter("client_id", CLIENT_ID);
        b.addParameter("scope", SCOPE);
        b.addParameter("response_type", "code");
        b.addParameter("redirect_uri", REDIRECT_URI);
        b.addParameter("state", code);
        return Mono.just(b.build().toURL().toString());
    }

    public Mono<CustomTokenResponse> getAccessToken(String authCode) {
        Map<String, String> authRequestVariables = new HashMap<>();
        authRequestVariables.put("redirect_uri", REDIRECT_URI);
        authRequestVariables.put("grant_type", "authorization_code");
        authRequestVariables.put("code", authCode);
        String encode = Base64.getEncoder().encodeToString((CLIENT_ID+":"+CLIENT_SECRET).getBytes());

        return webClient.post()
                .uri(uriBuilder -> uriBuilder.path(TOKEN_URI)
                        .queryParam("redirect_uri", REDIRECT_URI)
                        .queryParam("code", authCode)
                        .queryParam("grant_type", "authorization_code")
                        .build())
                .header("Authorization", "Basic " + encode)
                .retrieve()
                .bodyToMono(CustomTokenResponse.class);
    }


    public Mono<FileList> listFiles(String endPointId, String path, Boolean showHidden, Integer offset, Integer limit, String orderBy,
                               String filter) {

        String uri = ENDPOINT_FILE_LIST_URI.replace("{id}",endPointId);
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
                .uri(SUBMISSION_URI)
                .retrieve()
                .bodyToMono(Result.class);
    }

    public Mono<ActivationResult> activateEndPoint(String endPointId, String hostName, String serverDN, String userName, String password){

        String uri = ENDPOINT_ACTIVATION_URI.replace("{id}",endPointId);

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

        String uri = ENDPOINT_DETAIL_URI.replace("{id}",endPointId);
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(EndPoint.class);

    }

    public Mono<EndPointList> getEndPointList(String filterScope, String offset, String limit, String searchText){

        return webClient.get()
                .uri(builder -> builder.path(ENDPOINT_SEARCH_URI)
                        .queryParam("filter_scope",filterScope)
                        .queryParam("offset",offset)
                        .queryParam("limit",limit)
                        .queryParam("filter_fulltext", searchText)
                        .build())
                .retrieve()
                .bodyToMono(EndPointList.class);
    }


}
