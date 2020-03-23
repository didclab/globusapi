package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MkdirRequest {
    @JsonProperty("path")
    private String path;
    @JsonProperty("DATA_TYPE")
    private String dataType;

    public MkdirRequest() {
    }

    public String getPath() {
        return this.path;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MkdirRequest)) {
            return false;
        } else {
            MkdirRequest other = (MkdirRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$path = this.getPath();
                Object other$path = other.getPath();
                if (this$path == null) {
                    if (other$path != null) {
                        return false;
                    }
                } else if (!this$path.equals(other$path)) {
                    return false;
                }

                Object this$dataType = this.getDataType();
                Object other$dataType = other.getDataType();
                if (this$dataType == null) {
                    if (other$dataType != null) {
                        return false;
                    }
                } else if (!this$dataType.equals(other$dataType)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MkdirRequest;
    }

    public int hashCode() {
        Object $path = this.getPath();
        int result = 1 * 59 + ($path == null ? 43 : $path.hashCode());
        Object $dataType = this.getDataType();
        result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
        return result;
    }

    public String toString() {
        return "MkdirRequest(path=" + this.getPath() + ", dataType=" + this.getDataType() + ")";
    }
}
