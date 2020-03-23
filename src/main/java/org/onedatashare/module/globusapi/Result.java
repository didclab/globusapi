package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Result {
    @JsonProperty("DATA_TYPE")
    private String dataType;
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("task_id")
    private String taskId;
    @JsonProperty("submission_id")
    private String submissionId;
    @JsonProperty("resource")
    private String resource;
    @JsonProperty("value")
    private String value;

    public Result() {
    }

    public String getDataType() {
        return this.dataType;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getSubmissionId() {
        return this.submissionId;
    }

    public String getResource() {
        return this.resource;
    }

    public String getValue() {
        return this.value;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setRequestId(final String requestId) {
        this.requestId = requestId;
    }

    public void setTaskId(final String taskId) {
        this.taskId = taskId;
    }

    public void setSubmissionId(final String submissionId) {
        this.submissionId = submissionId;
    }

    public void setResource(final String resource) {
        this.resource = resource;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label107: {
                    Object this$dataType = this.getDataType();
                    Object other$dataType = other.getDataType();
                    if (this$dataType == null) {
                        if (other$dataType == null) {
                            break label107;
                        }
                    } else if (this$dataType.equals(other$dataType)) {
                        break label107;
                    }

                    return false;
                }

                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                label86: {
                    Object this$requestId = this.getRequestId();
                    Object other$requestId = other.getRequestId();
                    if (this$requestId == null) {
                        if (other$requestId == null) {
                            break label86;
                        }
                    } else if (this$requestId.equals(other$requestId)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$taskId = this.getTaskId();
                    Object other$taskId = other.getTaskId();
                    if (this$taskId == null) {
                        if (other$taskId == null) {
                            break label79;
                        }
                    } else if (this$taskId.equals(other$taskId)) {
                        break label79;
                    }

                    return false;
                }

                label72: {
                    Object this$submissionId = this.getSubmissionId();
                    Object other$submissionId = other.getSubmissionId();
                    if (this$submissionId == null) {
                        if (other$submissionId == null) {
                            break label72;
                        }
                    } else if (this$submissionId.equals(other$submissionId)) {
                        break label72;
                    }

                    return false;
                }

                Object this$resource = this.getResource();
                Object other$resource = other.getResource();
                if (this$resource == null) {
                    if (other$resource != null) {
                        return false;
                    }
                } else if (!this$resource.equals(other$resource)) {
                    return false;
                }

                Object this$value = this.getValue();
                Object other$value = other.getValue();
                if (this$value == null) {
                    if (other$value != null) {
                        return false;
                    }
                } else if (!this$value.equals(other$value)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Result;
    }

    public int hashCode() {
        Object $dataType = this.getDataType();
        int result = 1 * 59 + ($dataType == null ? 43 : $dataType.hashCode());
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $requestId = this.getRequestId();
        result = result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
        Object $taskId = this.getTaskId();
        result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
        Object $submissionId = this.getSubmissionId();
        result = result * 59 + ($submissionId == null ? 43 : $submissionId.hashCode());
        Object $resource = this.getResource();
        result = result * 59 + ($resource == null ? 43 : $resource.hashCode());
        Object $value = this.getValue();
        result = result * 59 + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    public String toString() {
        return "Result(dataType=" + this.getDataType() + ", code=" + this.getCode() + ", message=" + this.getMessage() + ", requestId=" + this.getRequestId() + ", taskId=" + this.getTaskId() + ", submissionId=" + this.getSubmissionId() + ", resource=" + this.getResource() + ", value=" + this.getValue() + ")";
    }
}
