package org.onedatashare.module.globusapi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
@Getter
public class GlobusConfig {
    private final String contentType = "application/json";
    @Value("${auth.base.url}")
    private String authBaseUrl;// = "https://auth.globus.org/v2/oauth2";
    @Value("$(auth.uri")
    private String authUri;// = "/authorize";
    @Value("${token.uri}")
    private String tokenUri;// = "/token";
    @Value("${transfer.base.url}")
    private String transferBaseUrl;// = "https://transfer.api.globusonline.org/v0.10";
    @Value("$(transfer.uri)")
    private String transferUri;// = "/transfer";
    @Value("${submission.uri}")
    private String submissionUri;// = "/submission_id";
    @Value("${scope}")
    private String scope;// = "urn:globus:auth:scope:transfer.api.globus.org:all urn:globus:auth:scope:auth.globus.org:view_identities offline_access";
    @Value("$(response.type)")
    private String responseType;// = "code";

    private static GlobusConfig instance;

    public static GlobusConfig getInstance(){
        if(instance == null){
            instance = new GlobusConfig();
        }
        return instance;
    }

}
