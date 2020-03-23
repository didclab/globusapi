package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class TaskSubmissionRequest {
    @JsonProperty("endpoint")
    String endpoint;
    @JsonProperty("DATA_TYPE")
    private String dataType;
    @JsonProperty("submission_id")
    private String submissionId;
    @JsonProperty("label")
    private String label;
    @JsonProperty("notify_on_succeeded")
    private Boolean notifyOnSucceeded;
    @JsonProperty("notify_on_failed")
    private Boolean notifyOnFailed;
    @JsonProperty("notify_on_inactive")
    private Boolean notifyOnInactive;
    @JsonProperty("skip_activation_check")
    private Boolean skipActivationCheck;
    @JsonProperty("deadline")
    private String deadline;
    @JsonProperty("recursive")
    private boolean recursive;
    @JsonProperty("source_endpoint")
    private String sourceEndpoint;
    @JsonProperty("destination_endpoint")
    private String destinationEndpoint;
    @JsonProperty("DATA")
    private List<TaskItem> data;
    @JsonProperty("encrypt_data")
    private Boolean encryptData;
    @JsonProperty("sync_level")
    private Integer syncLevel;
    @JsonProperty("verify_checksum")
    private Boolean verifyChecksum;
    @JsonProperty("preserve_timestamp")
    private Boolean preserveTimestamp;
    @JsonProperty("delete_destination_extra")
    private Boolean deleteDestinationExtra;
    @JsonProperty("ignore_missing")
    private Boolean ignoreMissing;
    @JsonProperty("interpret_globs")
    private Boolean interpretGlobs;
    @JsonProperty("recursive_symlinks")
    private String recursiveSymlinks;
    @JsonProperty("perf_cc")
    private Integer perfCC;
    @JsonProperty("perf_p")
    private Integer perfP;
    @JsonProperty("perf_pp")
    private Integer perfPP;
    @JsonProperty("perf_udt")
    private Boolean perfUDT;

    public TaskSubmissionRequest() {
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getDataType() {
        return this.dataType;
    }

    public String getSubmissionId() {
        return this.submissionId;
    }

    public String getLabel() {
        return this.label;
    }

    public Boolean getNotifyOnSucceeded() {
        return this.notifyOnSucceeded;
    }

    public Boolean getNotifyOnFailed() {
        return this.notifyOnFailed;
    }

    public Boolean getNotifyOnInactive() {
        return this.notifyOnInactive;
    }

    public Boolean getSkipActivationCheck() {
        return this.skipActivationCheck;
    }

    public String getDeadline() {
        return this.deadline;
    }

    public boolean isRecursive() {
        return this.recursive;
    }

    public String getSourceEndpoint() {
        return this.sourceEndpoint;
    }

    public String getDestinationEndpoint() {
        return this.destinationEndpoint;
    }

    public List<TaskItem> getData() {
        return this.data;
    }

    public Boolean getEncryptData() {
        return this.encryptData;
    }

    public Integer getSyncLevel() {
        return this.syncLevel;
    }

    public Boolean getVerifyChecksum() {
        return this.verifyChecksum;
    }

    public Boolean getPreserveTimestamp() {
        return this.preserveTimestamp;
    }

    public Boolean getDeleteDestinationExtra() {
        return this.deleteDestinationExtra;
    }

    public Boolean getIgnoreMissing() {
        return this.ignoreMissing;
    }

    public Boolean getInterpretGlobs() {
        return this.interpretGlobs;
    }

    public String getRecursiveSymlinks() {
        return this.recursiveSymlinks;
    }

    public Integer getPerfCC() {
        return this.perfCC;
    }

    public Integer getPerfP() {
        return this.perfP;
    }

    public Integer getPerfPP() {
        return this.perfPP;
    }

    public Boolean getPerfUDT() {
        return this.perfUDT;
    }

    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }

    public void setSubmissionId(final String submissionId) {
        this.submissionId = submissionId;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public void setNotifyOnSucceeded(final Boolean notifyOnSucceeded) {
        this.notifyOnSucceeded = notifyOnSucceeded;
    }

    public void setNotifyOnFailed(final Boolean notifyOnFailed) {
        this.notifyOnFailed = notifyOnFailed;
    }

    public void setNotifyOnInactive(final Boolean notifyOnInactive) {
        this.notifyOnInactive = notifyOnInactive;
    }

    public void setSkipActivationCheck(final Boolean skipActivationCheck) {
        this.skipActivationCheck = skipActivationCheck;
    }

    public void setDeadline(final String deadline) {
        this.deadline = deadline;
    }

    public void setRecursive(final boolean recursive) {
        this.recursive = recursive;
    }

    public void setSourceEndpoint(final String sourceEndpoint) {
        this.sourceEndpoint = sourceEndpoint;
    }

    public void setDestinationEndpoint(final String destinationEndpoint) {
        this.destinationEndpoint = destinationEndpoint;
    }

    public void setData(final List<TaskItem> data) {
        this.data = data;
    }

    public void setEncryptData(final Boolean encryptData) {
        this.encryptData = encryptData;
    }

    public void setSyncLevel(final Integer syncLevel) {
        this.syncLevel = syncLevel;
    }

    public void setVerifyChecksum(final Boolean verifyChecksum) {
        this.verifyChecksum = verifyChecksum;
    }

    public void setPreserveTimestamp(final Boolean preserveTimestamp) {
        this.preserveTimestamp = preserveTimestamp;
    }

    public void setDeleteDestinationExtra(final Boolean deleteDestinationExtra) {
        this.deleteDestinationExtra = deleteDestinationExtra;
    }

    public void setIgnoreMissing(final Boolean ignoreMissing) {
        this.ignoreMissing = ignoreMissing;
    }

    public void setInterpretGlobs(final Boolean interpretGlobs) {
        this.interpretGlobs = interpretGlobs;
    }

    public void setRecursiveSymlinks(final String recursiveSymlinks) {
        this.recursiveSymlinks = recursiveSymlinks;
    }

    public void setPerfCC(final Integer perfCC) {
        this.perfCC = perfCC;
    }

    public void setPerfP(final Integer perfP) {
        this.perfP = perfP;
    }

    public void setPerfPP(final Integer perfPP) {
        this.perfPP = perfPP;
    }

    public void setPerfUDT(final Boolean perfUDT) {
        this.perfUDT = perfUDT;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TaskSubmissionRequest)) {
            return false;
        } else {
            TaskSubmissionRequest other = (TaskSubmissionRequest) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label303:
                {
                    Object this$endpoint = this.getEndpoint();
                    Object other$endpoint = other.getEndpoint();
                    if (this$endpoint == null) {
                        if (other$endpoint == null) {
                            break label303;
                        }
                    } else if (this$endpoint.equals(other$endpoint)) {
                        break label303;
                    }

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

                Object this$submissionId = this.getSubmissionId();
                Object other$submissionId = other.getSubmissionId();
                if (this$submissionId == null) {
                    if (other$submissionId != null) {
                        return false;
                    }
                } else if (!this$submissionId.equals(other$submissionId)) {
                    return false;
                }

                label282:
                {
                    Object this$label = this.getLabel();
                    Object other$label = other.getLabel();
                    if (this$label == null) {
                        if (other$label == null) {
                            break label282;
                        }
                    } else if (this$label.equals(other$label)) {
                        break label282;
                    }

                    return false;
                }

                label275:
                {
                    Object this$notifyOnSucceeded = this.getNotifyOnSucceeded();
                    Object other$notifyOnSucceeded = other.getNotifyOnSucceeded();
                    if (this$notifyOnSucceeded == null) {
                        if (other$notifyOnSucceeded == null) {
                            break label275;
                        }
                    } else if (this$notifyOnSucceeded.equals(other$notifyOnSucceeded)) {
                        break label275;
                    }

                    return false;
                }

                Object this$notifyOnFailed = this.getNotifyOnFailed();
                Object other$notifyOnFailed = other.getNotifyOnFailed();
                if (this$notifyOnFailed == null) {
                    if (other$notifyOnFailed != null) {
                        return false;
                    }
                } else if (!this$notifyOnFailed.equals(other$notifyOnFailed)) {
                    return false;
                }

                Object this$notifyOnInactive = this.getNotifyOnInactive();
                Object other$notifyOnInactive = other.getNotifyOnInactive();
                if (this$notifyOnInactive == null) {
                    if (other$notifyOnInactive != null) {
                        return false;
                    }
                } else if (!this$notifyOnInactive.equals(other$notifyOnInactive)) {
                    return false;
                }

                label254:
                {
                    Object this$skipActivationCheck = this.getSkipActivationCheck();
                    Object other$skipActivationCheck = other.getSkipActivationCheck();
                    if (this$skipActivationCheck == null) {
                        if (other$skipActivationCheck == null) {
                            break label254;
                        }
                    } else if (this$skipActivationCheck.equals(other$skipActivationCheck)) {
                        break label254;
                    }

                    return false;
                }

                label247:
                {
                    Object this$deadline = this.getDeadline();
                    Object other$deadline = other.getDeadline();
                    if (this$deadline == null) {
                        if (other$deadline == null) {
                            break label247;
                        }
                    } else if (this$deadline.equals(other$deadline)) {
                        break label247;
                    }

                    return false;
                }

                if (this.isRecursive() != other.isRecursive()) {
                    return false;
                } else {
                    label239:
                    {
                        Object this$sourceEndpoint = this.getSourceEndpoint();
                        Object other$sourceEndpoint = other.getSourceEndpoint();
                        if (this$sourceEndpoint == null) {
                            if (other$sourceEndpoint == null) {
                                break label239;
                            }
                        } else if (this$sourceEndpoint.equals(other$sourceEndpoint)) {
                            break label239;
                        }

                        return false;
                    }

                    label232:
                    {
                        Object this$destinationEndpoint = this.getDestinationEndpoint();
                        Object other$destinationEndpoint = other.getDestinationEndpoint();
                        if (this$destinationEndpoint == null) {
                            if (other$destinationEndpoint == null) {
                                break label232;
                            }
                        } else if (this$destinationEndpoint.equals(other$destinationEndpoint)) {
                            break label232;
                        }

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

                    label218:
                    {
                        Object this$encryptData = this.getEncryptData();
                        Object other$encryptData = other.getEncryptData();
                        if (this$encryptData == null) {
                            if (other$encryptData == null) {
                                break label218;
                            }
                        } else if (this$encryptData.equals(other$encryptData)) {
                            break label218;
                        }

                        return false;
                    }

                    label211:
                    {
                        Object this$syncLevel = this.getSyncLevel();
                        Object other$syncLevel = other.getSyncLevel();
                        if (this$syncLevel == null) {
                            if (other$syncLevel == null) {
                                break label211;
                            }
                        } else if (this$syncLevel.equals(other$syncLevel)) {
                            break label211;
                        }

                        return false;
                    }

                    Object this$verifyChecksum = this.getVerifyChecksum();
                    Object other$verifyChecksum = other.getVerifyChecksum();
                    if (this$verifyChecksum == null) {
                        if (other$verifyChecksum != null) {
                            return false;
                        }
                    } else if (!this$verifyChecksum.equals(other$verifyChecksum)) {
                        return false;
                    }

                    Object this$preserveTimestamp = this.getPreserveTimestamp();
                    Object other$preserveTimestamp = other.getPreserveTimestamp();
                    if (this$preserveTimestamp == null) {
                        if (other$preserveTimestamp != null) {
                            return false;
                        }
                    } else if (!this$preserveTimestamp.equals(other$preserveTimestamp)) {
                        return false;
                    }

                    label190:
                    {
                        Object this$deleteDestinationExtra = this.getDeleteDestinationExtra();
                        Object other$deleteDestinationExtra = other.getDeleteDestinationExtra();
                        if (this$deleteDestinationExtra == null) {
                            if (other$deleteDestinationExtra == null) {
                                break label190;
                            }
                        } else if (this$deleteDestinationExtra.equals(other$deleteDestinationExtra)) {
                            break label190;
                        }

                        return false;
                    }

                    label183:
                    {
                        Object this$ignoreMissing = this.getIgnoreMissing();
                        Object other$ignoreMissing = other.getIgnoreMissing();
                        if (this$ignoreMissing == null) {
                            if (other$ignoreMissing == null) {
                                break label183;
                            }
                        } else if (this$ignoreMissing.equals(other$ignoreMissing)) {
                            break label183;
                        }

                        return false;
                    }

                    Object this$interpretGlobs = this.getInterpretGlobs();
                    Object other$interpretGlobs = other.getInterpretGlobs();
                    if (this$interpretGlobs == null) {
                        if (other$interpretGlobs != null) {
                            return false;
                        }
                    } else if (!this$interpretGlobs.equals(other$interpretGlobs)) {
                        return false;
                    }

                    label169:
                    {
                        Object this$recursiveSymlinks = this.getRecursiveSymlinks();
                        Object other$recursiveSymlinks = other.getRecursiveSymlinks();
                        if (this$recursiveSymlinks == null) {
                            if (other$recursiveSymlinks == null) {
                                break label169;
                            }
                        } else if (this$recursiveSymlinks.equals(other$recursiveSymlinks)) {
                            break label169;
                        }

                        return false;
                    }

                    Object this$perfCC = this.getPerfCC();
                    Object other$perfCC = other.getPerfCC();
                    if (this$perfCC == null) {
                        if (other$perfCC != null) {
                            return false;
                        }
                    } else if (!this$perfCC.equals(other$perfCC)) {
                        return false;
                    }

                    label155:
                    {
                        Object this$perfP = this.getPerfP();
                        Object other$perfP = other.getPerfP();
                        if (this$perfP == null) {
                            if (other$perfP == null) {
                                break label155;
                            }
                        } else if (this$perfP.equals(other$perfP)) {
                            break label155;
                        }

                        return false;
                    }

                    Object this$perfPP = this.getPerfPP();
                    Object other$perfPP = other.getPerfPP();
                    if (this$perfPP == null) {
                        if (other$perfPP != null) {
                            return false;
                        }
                    } else if (!this$perfPP.equals(other$perfPP)) {
                        return false;
                    }

                    Object this$perfUDT = this.getPerfUDT();
                    Object other$perfUDT = other.getPerfUDT();
                    if (this$perfUDT == null) {
                        if (other$perfUDT != null) {
                            return false;
                        }
                    } else if (!this$perfUDT.equals(other$perfUDT)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TaskSubmissionRequest;
    }

    public int hashCode() {
        Object $endpoint = this.getEndpoint();
        int result = 1 * 59 + ($endpoint == null ? 43 : $endpoint.hashCode());
        Object $dataType = this.getDataType();
        result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
        Object $submissionId = this.getSubmissionId();
        result = result * 59 + ($submissionId == null ? 43 : $submissionId.hashCode());
        Object $label = this.getLabel();
        result = result * 59 + ($label == null ? 43 : $label.hashCode());
        Object $notifyOnSucceeded = this.getNotifyOnSucceeded();
        result = result * 59 + ($notifyOnSucceeded == null ? 43 : $notifyOnSucceeded.hashCode());
        Object $notifyOnFailed = this.getNotifyOnFailed();
        result = result * 59 + ($notifyOnFailed == null ? 43 : $notifyOnFailed.hashCode());
        Object $notifyOnInactive = this.getNotifyOnInactive();
        result = result * 59 + ($notifyOnInactive == null ? 43 : $notifyOnInactive.hashCode());
        Object $skipActivationCheck = this.getSkipActivationCheck();
        result = result * 59 + ($skipActivationCheck == null ? 43 : $skipActivationCheck.hashCode());
        Object $deadline = this.getDeadline();
        result = result * 59 + ($deadline == null ? 43 : $deadline.hashCode());
        result = result * 59 + (this.isRecursive() ? 79 : 97);
        Object $sourceEndpoint = this.getSourceEndpoint();
        result = result * 59 + ($sourceEndpoint == null ? 43 : $sourceEndpoint.hashCode());
        Object $destinationEndpoint = this.getDestinationEndpoint();
        result = result * 59 + ($destinationEndpoint == null ? 43 : $destinationEndpoint.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $encryptData = this.getEncryptData();
        result = result * 59 + ($encryptData == null ? 43 : $encryptData.hashCode());
        Object $syncLevel = this.getSyncLevel();
        result = result * 59 + ($syncLevel == null ? 43 : $syncLevel.hashCode());
        Object $verifyChecksum = this.getVerifyChecksum();
        result = result * 59 + ($verifyChecksum == null ? 43 : $verifyChecksum.hashCode());
        Object $preserveTimestamp = this.getPreserveTimestamp();
        result = result * 59 + ($preserveTimestamp == null ? 43 : $preserveTimestamp.hashCode());
        Object $deleteDestinationExtra = this.getDeleteDestinationExtra();
        result = result * 59 + ($deleteDestinationExtra == null ? 43 : $deleteDestinationExtra.hashCode());
        Object $ignoreMissing = this.getIgnoreMissing();
        result = result * 59 + ($ignoreMissing == null ? 43 : $ignoreMissing.hashCode());
        Object $interpretGlobs = this.getInterpretGlobs();
        result = result * 59 + ($interpretGlobs == null ? 43 : $interpretGlobs.hashCode());
        Object $recursiveSymlinks = this.getRecursiveSymlinks();
        result = result * 59 + ($recursiveSymlinks == null ? 43 : $recursiveSymlinks.hashCode());
        Object $perfCC = this.getPerfCC();
        result = result * 59 + ($perfCC == null ? 43 : $perfCC.hashCode());
        Object $perfP = this.getPerfP();
        result = result * 59 + ($perfP == null ? 43 : $perfP.hashCode());
        Object $perfPP = this.getPerfPP();
        result = result * 59 + ($perfPP == null ? 43 : $perfPP.hashCode());
        Object $perfUDT = this.getPerfUDT();
        result = result * 59 + ($perfUDT == null ? 43 : $perfUDT.hashCode());
        return result;
    }

    public String toString() {
        return "TaskSubmissionRequest(endpoint=" + this.getEndpoint() + ", dataType=" + this.getDataType() + ", submissionId=" + this.getSubmissionId() + ", label=" + this.getLabel() + ", notifyOnSucceeded=" + this.getNotifyOnSucceeded() + ", notifyOnFailed=" + this.getNotifyOnFailed() + ", notifyOnInactive=" + this.getNotifyOnInactive() + ", skipActivationCheck=" + this.getSkipActivationCheck() + ", deadline=" + this.getDeadline() + ", recursive=" + this.isRecursive() + ", sourceEndpoint=" + this.getSourceEndpoint() + ", destinationEndpoint=" + this.getDestinationEndpoint() + ", data=" + this.getData() + ", encryptData=" + this.getEncryptData() + ", syncLevel=" + this.getSyncLevel() + ", verifyChecksum=" + this.getVerifyChecksum() + ", preserveTimestamp=" + this.getPreserveTimestamp() + ", deleteDestinationExtra=" + this.getDeleteDestinationExtra() + ", ignoreMissing=" + this.getIgnoreMissing() + ", interpretGlobs=" + this.getInterpretGlobs() + ", recursiveSymlinks=" + this.getRecursiveSymlinks() + ", perfCC=" + this.getPerfCC() + ", perfP=" + this.getPerfP() + ", perfPP=" + this.getPerfPP() + ", perfUDT=" + this.getPerfUDT() + ")";
    }
}