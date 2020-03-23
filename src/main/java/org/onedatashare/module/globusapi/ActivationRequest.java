package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class ActivationRequest {
    @JsonProperty("DATA")
    private List<ActivationRequirement> data;
    @JsonProperty("DATA_TYPE")
    private String dataType = "activation_requirements";
    @JsonProperty("activated")
    private boolean isActivated;
    @JsonProperty("auto_activation_supported")
    private boolean isAutoActivationSupported;
    @JsonProperty("expires_in")
    private int expiresIn;

    public ActivationRequest() {
    }

    public List<ActivationRequirement> getData() {
        return this.data;
    }

    public String getDataType() {
        return this.dataType;
    }

    public boolean isActivated() {
        return this.isActivated;
    }

    public boolean isAutoActivationSupported() {
        return this.isAutoActivationSupported;
    }

    public int getExpiresIn() {
        return this.expiresIn;
    }

    public void setData(final List<ActivationRequirement> data) {
        this.data = data;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }

    public void setActivated(final boolean isActivated) {
        this.isActivated = isActivated;
    }

    public void setAutoActivationSupported(final boolean isAutoActivationSupported) {
        this.isAutoActivationSupported = isAutoActivationSupported;
    }

    public void setExpiresIn(final int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ActivationRequest)) {
            return false;
        } else {
            ActivationRequest other = (ActivationRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$data = this.getData();
                    Object other$data = other.getData();
                    if (this$data == null) {
                        if (other$data == null) {
                            break label47;
                        }
                    } else if (this$data.equals(other$data)) {
                        break label47;
                    }

                    return false;
                }

                label40: {
                    Object this$dataType = this.getDataType();
                    Object other$dataType = other.getDataType();
                    if (this$dataType == null) {
                        if (other$dataType == null) {
                            break label40;
                        }
                    } else if (this$dataType.equals(other$dataType)) {
                        break label40;
                    }

                    return false;
                }

                if (this.isActivated() != other.isActivated()) {
                    return false;
                } else if (this.isAutoActivationSupported() != other.isAutoActivationSupported()) {
                    return false;
                } else {
                    return this.getExpiresIn() == other.getExpiresIn();
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ActivationRequest;
    }

    public int hashCode() {
        Object $data = this.getData();
        int result = 1 * 59 + ($data == null ? 43 : $data.hashCode());
        Object $dataType = this.getDataType();
        result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
        result = result * 59 + (this.isActivated() ? 79 : 97);
        result = result * 59 + (this.isAutoActivationSupported() ? 79 : 97);
        result = result * 59 + this.getExpiresIn();
        return result;
    }

    public String toString() {
        return "ActivationRequest(data=" + this.getData() + ", dataType=" + this.getDataType() + ", isActivated=" + this.isActivated() + ", isAutoActivationSupported=" + this.isAutoActivationSupported() + ", expiresIn=" + this.getExpiresIn() + ")";
    }
}
