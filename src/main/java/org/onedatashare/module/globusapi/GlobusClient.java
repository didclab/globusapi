package org.onedatashare.module.globusapi;

import com.google.api.client.auth.oauth2.TokenResponse;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Client to make calls to globus api
 */
@Accessors(chain = true)
public class GlobusClient {

    static final GlobusConfig globusConfig = GlobusConfig.getInstance();


    //These parameters have to be set when the client is created
    @Setter private String redirectUri;
    @Setter private String clientId;
    @Setter private String clientSecret;

    private WebClient webClient;

    //Access token for the user
    private String accessToken;

    /**
     * Creates a webClient for making requests to globus
     */
    public GlobusClient() {
        this.webClient = WebClient.builder()
                .baseUrl(globusConfig.getAuthBaseUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, globusConfig.getContentType())
                .build();
    }

    /**
     * Creates a webclient for making authenticated requests to globus on behalf of the user
     * @param accessToken
     */
    public GlobusClient(String accessToken) {
        this.accessToken = accessToken;
        this.webClient = WebClient.builder()
                .baseUrl(globusConfig.getTransferBaseUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, globusConfig.getContentType())
                .defaultHeader("Authorization", "Bearer " + this.accessToken)
                .build();
    }

    /**
     * Returns the oauth endpoint to connect with globus
     * @return
     * @throws URISyntaxException
     * @throws MalformedURLException
     */
    public Mono<String> generateOAuthURL() throws URISyntaxException, MalformedURLException {
        String code = RandomStringUtils.random(25, true, true);
        URIBuilder b = new URIBuilder(globusConfig.getAuthBaseUrl() + globusConfig.getAuthUri());
        b.addParameter("client_id", clientId);
        b.addParameter("scope", globusConfig.getScope());
        b.addParameter("response_type", "code");
        b.addParameter("redirect_uri", redirectUri);
        b.addParameter("state", code);
        return Mono.just(b.build().toURL().toString());
    }

    /**
     * Fetches the access token from globus
     * @param authCode
     * @return
     */
    public Mono<String> getAccessToken(String authCode) {
        Map<String, String> authRequestVariables = new HashMap<>();
        authRequestVariables.put("redirect_uri", redirectUri);
        authRequestVariables.put("grant_type", authCode);
        return webClient.get()
                .uri(globusConfig.getTokenUri(), authRequestVariables)
                .retrieve()
                .bodyToMono(TokenResponse.class)
                .map(TokenResponse::getAccessToken);
    }

    /**
     * This method lists the folders and files on the given endpoint
     * @param path
     * @param showHidden
     * @param limit
     * @param offset
     * @param orderBy
     * @param filter
     * @return
     */
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
                .uri(globusConfig.getTransferUri(), listRequestVariables)
                .retrieve()
                .bodyToMono(FileList.class);
    }

    /**
     * Creates a new folder at the endpoint
     * @param taskSubmissionRequest
     * @param endpointId
     * @return
     */
    public Mono<Result> mkdir(TaskSubmissionRequest taskSubmissionRequest, String endpointId) {
        return webClient.post()
                .uri("/operation/endpoint/" + endpointId + "/mkdir")
                .syncBody(taskSubmissionRequest)
                .retrieve()
                .bodyToMono(Result.class);
    }

    /**
     * Submits a transfer request to the globus
     * @param taskSubmissionRequest
     * @return
     */
    public Mono<Result> submitTask(TaskSubmissionRequest taskSubmissionRequest) {
        return webClient.post()
                .uri("/" + taskSubmissionRequest.getDataType())
                .syncBody(taskSubmissionRequest)
                .retrieve()
                .bodyToMono(Result.class);
    }

    /**
     * Returns the transfer id
     * @return
     */
    public Mono<String> getJobSubmissionId() {
        return webClient.get()
                .uri(globusConfig.getSubmissionUri())
                .retrieve()
                .bodyToMono(String.class);
    }
}
