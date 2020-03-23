package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class FileList {
    @JsonProperty("DATA_TYPE")
    String dataType;
    @JsonProperty("path")
    String path;
    @JsonProperty("absolute_path")
    String absolutePath;
    @JsonProperty("endpoint")
    String endpoint;
    @JsonProperty("rename_supported")
    Boolean renameSupported;
    @JsonProperty("symlink_supported")
    Boolean symlinkSupported;
    @JsonProperty("DATA")
    List<File> data;

    public FileList() {
    }

    public String getDataType() {
        return this.dataType;
    }

    public String getPath() {
        return this.path;
    }

    public String getAbsolutePath() {
        return this.absolutePath;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public Boolean getRenameSupported() {
        return this.renameSupported;
    }

    public Boolean getSymlinkSupported() {
        return this.symlinkSupported;
    }

    public List<File> getData() {
        return this.data;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public void setAbsolutePath(final String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    public void setRenameSupported(final Boolean renameSupported) {
        this.renameSupported = renameSupported;
    }

    public void setSymlinkSupported(final Boolean symlinkSupported) {
        this.symlinkSupported = symlinkSupported;
    }

    public void setData(final List<File> data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof FileList)) {
            return false;
        } else {
            FileList other = (FileList)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$dataType = this.getDataType();
                    Object other$dataType = other.getDataType();
                    if (this$dataType == null) {
                        if (other$dataType == null) {
                            break label95;
                        }
                    } else if (this$dataType.equals(other$dataType)) {
                        break label95;
                    }

                    return false;
                }

                Object this$path = this.getPath();
                Object other$path = other.getPath();
                if (this$path == null) {
                    if (other$path != null) {
                        return false;
                    }
                } else if (!this$path.equals(other$path)) {
                    return false;
                }

                Object this$absolutePath = this.getAbsolutePath();
                Object other$absolutePath = other.getAbsolutePath();
                if (this$absolutePath == null) {
                    if (other$absolutePath != null) {
                        return false;
                    }
                } else if (!this$absolutePath.equals(other$absolutePath)) {
                    return false;
                }

                label74: {
                    Object this$endpoint = this.getEndpoint();
                    Object other$endpoint = other.getEndpoint();
                    if (this$endpoint == null) {
                        if (other$endpoint == null) {
                            break label74;
                        }
                    } else if (this$endpoint.equals(other$endpoint)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$renameSupported = this.getRenameSupported();
                    Object other$renameSupported = other.getRenameSupported();
                    if (this$renameSupported == null) {
                        if (other$renameSupported == null) {
                            break label67;
                        }
                    } else if (this$renameSupported.equals(other$renameSupported)) {
                        break label67;
                    }

                    return false;
                }

                Object this$symlinkSupported = this.getSymlinkSupported();
                Object other$symlinkSupported = other.getSymlinkSupported();
                if (this$symlinkSupported == null) {
                    if (other$symlinkSupported != null) {
                        return false;
                    }
                } else if (!this$symlinkSupported.equals(other$symlinkSupported)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FileList;
    }

    public int hashCode() {
        Object $dataType = this.getDataType();
        int result = 1 * 59 + ($dataType == null ? 43 : $dataType.hashCode());
        Object $path = this.getPath();
        result = result * 59 + ($path == null ? 43 : $path.hashCode());
        Object $absolutePath = this.getAbsolutePath();
        result = result * 59 + ($absolutePath == null ? 43 : $absolutePath.hashCode());
        Object $endpoint = this.getEndpoint();
        result = result * 59 + ($endpoint == null ? 43 : $endpoint.hashCode());
        Object $renameSupported = this.getRenameSupported();
        result = result * 59 + ($renameSupported == null ? 43 : $renameSupported.hashCode());
        Object $symlinkSupported = this.getSymlinkSupported();
        result = result * 59 + ($symlinkSupported == null ? 43 : $symlinkSupported.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "FileList(dataType=" + this.getDataType() + ", path=" + this.getPath() + ", absolutePath=" + this.getAbsolutePath() + ", endpoint=" + this.getEndpoint() + ", renameSupported=" + this.getRenameSupported() + ", symlinkSupported=" + this.getSymlinkSupported() + ", data=" + this.getData() + ")";
    }
}
