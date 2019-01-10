package org.onedatashare.module.globusapi;

import com.google.api.client.auth.oauth2.TokenResponse;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class GlobusClient {
    private static final String CONTENT_TYPE = "application/json";
    private final WebClient webClient;
    @Value("${auth.base.url}")
    String AUTH_BASE_URL;// = "https://auth.globus.org/v2/oauth2";
    @Value("$(auth.uri")
    String AUTH_URI;// = "/authorize";
    @Value("${token.uri}")
    String TOKEN_URI;// = "/token";
    @Value("${transfer.base.url}")
    String TRANSFER_BASE_URL;// = "https://transfer.api.globusonline.org/v0.10";
    @Value("$(transfer.uri)")
    String TRANSFER_URI;// = "/transfer";
    @Value("${submission.uri}")
    String SUBMISSION_URI;// = "/submission_id";
    @Value("${redirect.uri}")
    String REDIRECT_URI;// = "https://127.0.0.1:8080/api/stork/oauth";
    @Value("${client.id}")
    String CLIENT_ID;// = "6843af68-87f8-4341-bfc4-3db4b1e2d845";
    @Value("${client.secret}")
    String CLIENT_SECRET;// = "IsqQ6AlvDCi/z5em+D6NJl2cRFq9gFt0jm9GRseQek0=";
    @Value("${scope}")
    String SCOPE;// = "urn:globus:auth:scope:transfer.api.globus.org:all urn:globus:auth:scope:auth.globus.org:view_identities offline_access";
    @Value("$(response.type)")
    String RESPONSE_TYPE;// = "code";
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

    public Mono<String> getAccessToken(String authCode) {
        Map<String, String> authRequestVariables = new HashMap<>();
        authRequestVariables.put("redirect_uri", REDIRECT_URI);
        authRequestVariables.put("grant_type", authCode);
        return webClient.get()
                .uri(TOKEN_URI, authRequestVariables)
                .retrieve()
                .bodyToMono(TokenResponse.class)
                .map(TokenResponse::getAccessToken);
    }

    public Mono<FileList> list(String path, Boolean showHidden, Integer limit, Integer offset, String orderBy,
                               String filter) {
        Map<String, Object> listRequestVariables = new HashMap<>();
        listRequestVariables.put("path", path);
        listRequestVariables.put("show_hidden", showHidden);
        listRequestVariables.put("limit", limit);
        listRequestVariables.put("offset", offset);
        listRequestVariables.put("orderby", orderBy);
        listRequestVariables.put("filter", filter);
        return webClient.get()
                .uri(TRANSFER_URI, listRequestVariables)
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

    public Mono<String> getJobSubmissionId() {
        return webClient.get()
                .uri(SUBMISSION_URI)
                .retrieve()
                .bodyToMono(String.class);
    }


}
