package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    @JsonProperty("DATA_TYPE")
    private String dataType;
    @JsonProperty("task_id")
    private String taskId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("status")
    private String status;
    @JsonProperty("label")
    private String label;
    @JsonProperty("owner_id")
    private String ownerId;
    @JsonProperty("request_time")
    private String requestTime;
    @JsonProperty("completion_time")
    private String completionTime;
    @JsonProperty("deadline")
    private String deadline;
    @JsonProperty("source_endpoint_id")
    private String sourceEndpointId;
    @JsonProperty("destination_endpoint_id")
    private String destinationEndpointId;
    @JsonProperty("files")
    private Integer files;
    @JsonProperty("directories")
    private Integer directories;
    @JsonProperty("bytes_transferred")
    private Integer bytes_transferred;
    @JsonProperty("is_paused")
    private String isPaused;

    public Task() {
    }

    public String getDataType() {
        return this.dataType;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getType() {
        return this.type;
    }

    public String getStatus() {
        return this.status;
    }

    public String getLabel() {
        return this.label;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getRequestTime() {
        return this.requestTime;
    }

    public String getCompletionTime() {
        return this.completionTime;
    }

    public String getDeadline() {
        return this.deadline;
    }

    public String getSourceEndpointId() {
        return this.sourceEndpointId;
    }

    public String getDestinationEndpointId() {
        return this.destinationEndpointId;
    }

    public Integer getFiles() {
        return this.files;
    }

    public Integer getDirectories() {
        return this.directories;
    }

    public Integer getBytes_transferred() {
        return this.bytes_transferred;
    }

    public String getIsPaused() {
        return this.isPaused;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }

    public void setTaskId(final String taskId) {
        this.taskId = taskId;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public void setOwnerId(final String ownerId) {
        this.ownerId = ownerId;
    }

    public void setRequestTime(final String requestTime) {
        this.requestTime = requestTime;
    }

    public void setCompletionTime(final String completionTime) {
        this.completionTime = completionTime;
    }

    public void setDeadline(final String deadline) {
        this.deadline = deadline;
    }

    public void setSourceEndpointId(final String sourceEndpointId) {
        this.sourceEndpointId = sourceEndpointId;
    }

    public void setDestinationEndpointId(final String destinationEndpointId) {
        this.destinationEndpointId = destinationEndpointId;
    }

    public void setFiles(final Integer files) {
        this.files = files;
    }

    public void setDirectories(final Integer directories) {
        this.directories = directories;
    }

    public void setBytes_transferred(final Integer bytes_transferred) {
        this.bytes_transferred = bytes_transferred;
    }

    public void setIsPaused(final String isPaused) {
        this.isPaused = isPaused;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Task)) {
            return false;
        } else {
            Task other = (Task)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label191: {
                    Object this$dataType = this.getDataType();
                    Object other$dataType = other.getDataType();
                    if (this$dataType == null) {
                        if (other$dataType == null) {
                            break label191;
                        }
                    } else if (this$dataType.equals(other$dataType)) {
                        break label191;
                    }

                    return false;
                }

                Object this$taskId = this.getTaskId();
                Object other$taskId = other.getTaskId();
                if (this$taskId == null) {
                    if (other$taskId != null) {
                        return false;
                    }
                } else if (!this$taskId.equals(other$taskId)) {
                    return false;
                }

                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
                    return false;
                }

                label170: {
                    Object this$status = this.getStatus();
                    Object other$status = other.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label170;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label170;
                    }

                    return false;
                }

                label163: {
                    Object this$label = this.getLabel();
                    Object other$label = other.getLabel();
                    if (this$label == null) {
                        if (other$label == null) {
                            break label163;
                        }
                    } else if (this$label.equals(other$label)) {
                        break label163;
                    }

                    return false;
                }

                Object this$ownerId = this.getOwnerId();
                Object other$ownerId = other.getOwnerId();
                if (this$ownerId == null) {
                    if (other$ownerId != null) {
                        return false;
                    }
                } else if (!this$ownerId.equals(other$ownerId)) {
                    return false;
                }

                Object this$requestTime = this.getRequestTime();
                Object other$requestTime = other.getRequestTime();
                if (this$requestTime == null) {
                    if (other$requestTime != null) {
                        return false;
                    }
                } else if (!this$requestTime.equals(other$requestTime)) {
                    return false;
                }

                label142: {
                    Object this$completionTime = this.getCompletionTime();
                    Object other$completionTime = other.getCompletionTime();
                    if (this$completionTime == null) {
                        if (other$completionTime == null) {
                            break label142;
                        }
                    } else if (this$completionTime.equals(other$completionTime)) {
                        break label142;
                    }

                    return false;
                }

                label135: {
                    Object this$deadline = this.getDeadline();
                    Object other$deadline = other.getDeadline();
                    if (this$deadline == null) {
                        if (other$deadline == null) {
                            break label135;
                        }
                    } else if (this$deadline.equals(other$deadline)) {
                        break label135;
                    }

                    return false;
                }

                Object this$sourceEndpointId = this.getSourceEndpointId();
                Object other$sourceEndpointId = other.getSourceEndpointId();
                if (this$sourceEndpointId == null) {
                    if (other$sourceEndpointId != null) {
                        return false;
                    }
                } else if (!this$sourceEndpointId.equals(other$sourceEndpointId)) {
                    return false;
                }

                label121: {
                    Object this$destinationEndpointId = this.getDestinationEndpointId();
                    Object other$destinationEndpointId = other.getDestinationEndpointId();
                    if (this$destinationEndpointId == null) {
                        if (other$destinationEndpointId == null) {
                            break label121;
                        }
                    } else if (this$destinationEndpointId.equals(other$destinationEndpointId)) {
                        break label121;
                    }

                    return false;
                }

                Object this$files = this.getFiles();
                Object other$files = other.getFiles();
                if (this$files == null) {
                    if (other$files != null) {
                        return false;
                    }
                } else if (!this$files.equals(other$files)) {
                    return false;
                }

                label107: {
                    Object this$directories = this.getDirectories();
                    Object other$directories = other.getDirectories();
                    if (this$directories == null) {
                        if (other$directories == null) {
                            break label107;
                        }
                    } else if (this$directories.equals(other$directories)) {
                        break label107;
                    }

                    return false;
                }

                Object this$bytes_transferred = this.getBytes_transferred();
                Object other$bytes_transferred = other.getBytes_transferred();
                if (this$bytes_transferred == null) {
                    if (other$bytes_transferred != null) {
                        return false;
                    }
                } else if (!this$bytes_transferred.equals(other$bytes_transferred)) {
                    return false;
                }

                Object this$isPaused = this.getIsPaused();
                Object other$isPaused = other.getIsPaused();
                if (this$isPaused == null) {
                    if (other$isPaused != null) {
                        return false;
                    }
                } else if (!this$isPaused.equals(other$isPaused)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Task;
    }

    public int hashCode() {
        Object $dataType = this.getDataType();
        int result = 1 * 59 + ($dataType == null ? 43 : $dataType.hashCode());
        Object $taskId = this.getTaskId();
        result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $label = this.getLabel();
        result = result * 59 + ($label == null ? 43 : $label.hashCode());
        Object $ownerId = this.getOwnerId();
        result = result * 59 + ($ownerId == null ? 43 : $ownerId.hashCode());
        Object $requestTime = this.getRequestTime();
        result = result * 59 + ($requestTime == null ? 43 : $requestTime.hashCode());
        Object $completionTime = this.getCompletionTime();
        result = result * 59 + ($completionTime == null ? 43 : $completionTime.hashCode());
        Object $deadline = this.getDeadline();
        result = result * 59 + ($deadline == null ? 43 : $deadline.hashCode());
        Object $sourceEndpointId = this.getSourceEndpointId();
        result = result * 59 + ($sourceEndpointId == null ? 43 : $sourceEndpointId.hashCode());
        Object $destinationEndpointId = this.getDestinationEndpointId();
        result = result * 59 + ($destinationEndpointId == null ? 43 : $destinationEndpointId.hashCode());
        Object $files = this.getFiles();
        result = result * 59 + ($files == null ? 43 : $files.hashCode());
        Object $directories = this.getDirectories();
        result = result * 59 + ($directories == null ? 43 : $directories.hashCode());
        Object $bytes_transferred = this.getBytes_transferred();
        result = result * 59 + ($bytes_transferred == null ? 43 : $bytes_transferred.hashCode());
        Object $isPaused = this.getIsPaused();
        result = result * 59 + ($isPaused == null ? 43 : $isPaused.hashCode());
        return result;
    }

    public String toString() {
        return "Task(dataType=" + this.getDataType() + ", taskId=" + this.getTaskId() + ", type=" + this.getType() + ", status=" + this.getStatus() + ", label=" + this.getLabel() + ", ownerId=" + this.getOwnerId() + ", requestTime=" + this.getRequestTime() + ", completionTime=" + this.getCompletionTime() + ", deadline=" + this.getDeadline() + ", sourceEndpointId=" + this.getSourceEndpointId() + ", destinationEndpointId=" + this.getDestinationEndpointId() + ", files=" + this.getFiles() + ", directories=" + this.getDirectories() + ", bytes_transferred=" + this.getBytes_transferred() + ", isPaused=" + this.getIsPaused() + ")";
    }
}
