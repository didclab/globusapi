package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.concurrent.Task;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GlobusClientV010 {
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
    String ValidateUri = "https://auth.globus.org/v2/oauth2/token/validate";

    String DeactiveUri = "https://transfer.api.globus.org/v0.10/endpoint/9c69d656-1d6f-11e9-9fa0-0a06afd4a22e/deactivate";
    String listUrl = "https://transfer.api.globus.org/v0.10/endpoint_mru_list";

    String searchurl = "https://transfer.api.globus.org/v0.10/endpoint_search";

    private String accessToken;

    public GlobusClientV010() {
        this.webClient = WebClient.builder()
                .baseUrl(AUTH_BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE)
                .build();
    }

    public GlobusClientV010(String accessToken) {
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

    public Mono<Boolean> Validate(String clientId){
        return webClient.post()
                .uri(ValidateUri)
                .syncBody(new ValidateForm(accessToken, clientId))
                .retrieve()
                .bodyToMono(ActiveResponse.class)
                .map(u->u.getActive());
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

    public Mono<Result> deactivate(TaskSubmissionRequest taskSubmissionRequest, String endpointId) {
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


    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class ValidateForm{
        @JsonProperty("token")
        String token;
        @JsonProperty("client_id")
        String clientid;
        @JsonProperty("token_type_hint")
        String tth = "access_token";
        public ValidateForm(String token, String clientid){
            super();
            setToken(token);
            setClientid(clientid);
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class ActiveResponse{
        @JsonProperty("active")
        Boolean active;

    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class GridftpEndpointSearchQuery{
        @JsonProperty("filter_fulltext")
        String filter_fulltext;
        @JsonProperty("limit")
        Integer limit = 10;
        @JsonProperty("offset")
        Integer offset = 0;
        public GridftpEndpointSearchQuery(String text){
            filter_fulltext = text;
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class GridftpEndpointSearchResponse{
        @JsonProperty("DATA_TYPE")
        String DATA_TYPE;
        @JsonProperty("_rank")
        Double _rank;
        @JsonProperty("acl_available")
        Boolean acl_available;
        @JsonProperty("acl_editable")
        Boolean acl_editable;
        @JsonProperty("activated")
        Boolean activated;
        @JsonProperty("authentication_assurance_timeout")
        Integer authentication_assurance_timeout;
        @JsonProperty("canonical_name")
        String canonical_name;
        @JsonProperty("contact_email")
        String contact_email;
        @JsonProperty("contact_info")
        String contact_info;
        @JsonProperty("default_directory")
        String default_directory;
        @JsonProperty("department")
        String department;
        @JsonProperty("description")
        String description;
        @JsonProperty("disable_verify")
        Boolean disable_verify;

        @JsonProperty("display_name")
        String display_name;
        @JsonProperty("expire_time")
        Integer expire_time;
        @JsonProperty("expires_in")
        Integer expires_in;

        @JsonProperty("force_encryption")
        Boolean force_encryption;
        @JsonProperty("gcp_connected")
        Boolean gcp_connected;
        @JsonProperty("gcp_paused")
        Boolean gcp_paused;

        @JsonProperty("globus_connect_setup_key")
        String globus_connect_setup_key;
        @JsonProperty("host_endpoint")
        String host_endpoint;
        @JsonProperty("host_endpoint_display_name")
        String host_endpoint_display_name;
        @JsonProperty("host_endpoint_id")
        String host_endpoint_id;
        @JsonProperty("host_path")
        String host_path;

        @JsonProperty("https_server")
        String https_server;
        @JsonProperty("id")
        String id;

        @JsonProperty("in_use")
        Boolean in_use;
        @JsonProperty("info_link")
        String info_link;
        @JsonProperty("is_globus_connect")
        Boolean is_globus_connect;
        @JsonProperty("is_go_storage")
        Boolean is_go_storage;

        @JsonProperty("keywords")
        String keywords;
        @JsonProperty("local_user_info_available")
        Boolean local_user_info_available;

        @JsonProperty("location")
        String location;

        @JsonProperty("max_concurrency")
        Integer max_concurrency;

        @JsonProperty("max_parallelism")
        Integer max_parallelism;

        @JsonProperty("my_effective_roles")
        ArrayList<String> my_effective_roles;

        @JsonProperty("myproxy_dn")
        String myproxy_dn;
        @JsonProperty("myproxy_server")
        String myproxy_server;
        @JsonProperty("name")
        String name;

        @JsonProperty("network_use")
        String network_use;
        @JsonProperty("non_functional")
        Boolean non_functional;
        @JsonProperty("oauth_server")
        String oauth_server;
        @JsonProperty("organization")
        String organization;
        @JsonProperty("owner_id")
        String owner_id;
        @JsonProperty("owner_string")
        String owner_string;

        @JsonProperty("preferred_concurrency")
        Integer preferred_concurrency;
        @JsonProperty("preferred_parallelism")
        Integer preferred_parallelism;

        @JsonProperty("public")
        Boolean publicvar;
        @JsonProperty("s3_owner_activated")
        Boolean s3_owner_activated;
        @JsonProperty("s3_url")
        String s3_url;
        @JsonProperty("shareable")
        Boolean shareable;

        @JsonProperty("sharing_target_endpoint")
        String sharing_target_endpoint;
        @JsonProperty("sharing_target_root_path")
        String sharing_target_root_path;
        @JsonProperty("storage_type")
        String storage_type;
        @JsonProperty("subscription_id")
        String subscription_id;
        @JsonProperty("tlsftp_server")
        String tlsftp_server;
        @JsonProperty("username")
        String username;




    }
}
