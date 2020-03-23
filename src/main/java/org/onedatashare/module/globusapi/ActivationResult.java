package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ActivationResult extends Result {
    private String endpoint;
    @JsonProperty("expire_time")
    private String expireTime;
    @JsonProperty("expires_in")
    private int expiresIn;

    public ActivationResult() {
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public int getExpiresIn() {
        return this.expiresIn;
    }

    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    public void setExpireTime(final String expireTime) {
        this.expireTime = expireTime;
    }

    public void setExpiresIn(final int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ActivationResult)) {
            return false;
        } else {
            ActivationResult other = (ActivationResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label39: {
                    Object this$endpoint = this.getEndpoint();
                    Object other$endpoint = other.getEndpoint();
                    if (this$endpoint == null) {
                        if (other$endpoint == null) {
                            break label39;
                        }
                    } else if (this$endpoint.equals(other$endpoint)) {
                        break label39;
                    }

                    return false;
                }

                Object this$expireTime = this.getExpireTime();
                Object other$expireTime = other.getExpireTime();
                if (this$expireTime == null) {
                    if (other$expireTime != null) {
                        return false;
                    }
                } else if (!this$expireTime.equals(other$expireTime)) {
                    return false;
                }

                if (this.getExpiresIn() != other.getExpiresIn()) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ActivationResult;
    }

    public int hashCode() {
        Object $endpoint = this.getEndpoint();
        int result = 1 * 59 + ($endpoint == null ? 43 : $endpoint.hashCode());
        Object $expireTime = this.getExpireTime();
        result = result * 59 + ($expireTime == null ? 43 : $expireTime.hashCode());
        result = result * 59 + this.getExpiresIn();
        return result;
    }

    public String toString() {
        return "ActivationResult(endpoint=" + this.getEndpoint() + ", expireTime=" + this.getExpireTime() + ", expiresIn=" + this.getExpiresIn() + ")";
    }
}
