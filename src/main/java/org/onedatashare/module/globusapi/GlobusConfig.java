package org.onedatashare.module.globusapi;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GlobusConfig {
    private final String contentType = "application/json";
    private final String authBaseUrl ="https://auth.globus.org/v2/oauth2";
    private final String authUri =  "/authorize";
    private String tokenUri = "/token";
    private String transferBaseUrl = "https://transfer.api.globusonline.org/v0.10";
    private String transferUri = "/transfer";
    private String submissionUri = "/submission_id";
    private String scope = "urn:globus:auth:scope:transfer.api.globus.org:all urn:globus:auth:scope:auth.globus.org:view_identities offline_access";
    private String responseType = "code";
}
