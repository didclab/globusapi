//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TaskItem {
    @JsonProperty("DATA_TYPE")
    private String dataType;
    @JsonProperty("source_path")
    private String sourcePath;
    @JsonProperty("destination_path")
    private String destinationPath;
    @JsonProperty("recursive")
    private Boolean recursive;
    @JsonProperty("path")
    private String path;

    public TaskItem() {
    }

    public String getDataType() {
        return this.dataType;
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

    public String getDestinationPath() {
        return this.destinationPath;
    }

    public Boolean getRecursive() {
        return this.recursive;
    }

    public String getPath() {
        return this.path;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }

    public void setSourcePath(final String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void setDestinationPath(final String destinationPath) {
        this.destinationPath = destinationPath;
    }

    public void setRecursive(final Boolean recursive) {
        this.recursive = recursive;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TaskItem)) {
            return false;
        } else {
            TaskItem other = (TaskItem)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$dataType = this.getDataType();
                    Object other$dataType = other.getDataType();
                    if (this$dataType == null) {
                        if (other$dataType == null) {
                            break label71;
                        }
                    } else if (this$dataType.equals(other$dataType)) {
                        break label71;
                    }

                    return false;
                }

                Object this$sourcePath = this.getSourcePath();
                Object other$sourcePath = other.getSourcePath();
                if (this$sourcePath == null) {
                    if (other$sourcePath != null) {
                        return false;
                    }
                } else if (!this$sourcePath.equals(other$sourcePath)) {
                    return false;
                }

                label57: {
                    Object this$destinationPath = this.getDestinationPath();
                    Object other$destinationPath = other.getDestinationPath();
                    if (this$destinationPath == null) {
                        if (other$destinationPath == null) {
                            break label57;
                        }
                    } else if (this$destinationPath.equals(other$destinationPath)) {
                        break label57;
                    }

                    return false;
                }

                Object this$recursive = this.getRecursive();
                Object other$recursive = other.getRecursive();
                if (this$recursive == null) {
                    if (other$recursive != null) {
                        return false;
                    }
                } else if (!this$recursive.equals(other$recursive)) {
                    return false;
                }

                Object this$path = this.getPath();
                Object other$path = other.getPath();
                if (this$path == null) {
                    if (other$path == null) {
                        return true;
                    }
                } else if (this$path.equals(other$path)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TaskItem;
    }

    public int hashCode() {
        Object $dataType = this.getDataType();
        int result = 1 * 59 + ($dataType == null ? 43 : $dataType.hashCode());
        Object $sourcePath = this.getSourcePath();
        result = result * 59 + ($sourcePath == null ? 43 : $sourcePath.hashCode());
        Object $destinationPath = this.getDestinationPath();
        result = result * 59 + ($destinationPath == null ? 43 : $destinationPath.hashCode());
        Object $recursive = this.getRecursive();
        result = result * 59 + ($recursive == null ? 43 : $recursive.hashCode());
        Object $path = this.getPath();
        result = result * 59 + ($path == null ? 43 : $path.hashCode());
        return result;
    }

    public String toString() {
        return "TaskItem(dataType=" + this.getDataType() + ", sourcePath=" + this.getSourcePath() + ", destinationPath=" + this.getDestinationPath() + ", recursive=" + this.getRecursive() + ", path=" + this.getPath() + ")";
    }
}
