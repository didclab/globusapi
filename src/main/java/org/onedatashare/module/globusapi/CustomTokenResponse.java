//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.onedatashare.module.globusapi;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;

public class CustomTokenResponse extends GenericJson {
    @Key("access_token")
    private String accessToken;
    @Key("token_type")
    private String tokenType;
    @Key("expires_in")
    private Integer expiresInSeconds;
    @Key("refresh_token")
    private String refreshToken;
    @Key
    private String scope;

    public CustomTokenResponse() {
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public CustomTokenResponse setAccessToken(String accessToken) {
        this.accessToken = (String)Preconditions.checkNotNull(accessToken);
        return this;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public CustomTokenResponse setTokenType(String tokenType) {
        this.tokenType = (String)Preconditions.checkNotNull(tokenType);
        return this;
    }

    public final Integer getExpiresInSeconds() {
        return this.expiresInSeconds;
    }

    public CustomTokenResponse setExpiresInSeconds(Integer expiresInSeconds) {
        this.expiresInSeconds = expiresInSeconds;
        return this;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public CustomTokenResponse setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public final String getScope() {
        return this.scope;
    }

    public CustomTokenResponse setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public CustomTokenResponse set(String fieldName, Object value) {
        return (CustomTokenResponse)super.set(fieldName, value);
    }

    public CustomTokenResponse clone() {
        return (CustomTokenResponse)super.clone();
    }
}
