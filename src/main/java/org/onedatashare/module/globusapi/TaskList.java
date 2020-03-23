package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TaskList {
    @JsonProperty("DATA_TYPE")
    private String dataType;
    @JsonProperty("length")
    private int length;
    @JsonProperty("limit")
    private int limit;
    @JsonProperty("offset")
    private int offset;
    @JsonProperty("total")
    private int total;
    @JsonProperty("DATA")
    private List<Task> data;

    public TaskList() {
    }

    public String getDataType() {
        return this.dataType;
    }

    public int getLength() {
        return this.length;
    }

    public int getLimit() {
        return this.limit;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getTotal() {
        return this.total;
    }

    public List<Task> getData() {
        return this.data;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }

    public void setLength(final int length) {
        this.length = length;
    }

    public void setLimit(final int limit) {
        this.limit = limit;
    }

    public void setOffset(final int offset) {
        this.offset = offset;
    }

    public void setTotal(final int total) {
        this.total = total;
    }

    public void setData(final List<Task> data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TaskList)) {
            return false;
        } else {
            TaskList other = (TaskList)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$dataType = this.getDataType();
                Object other$dataType = other.getDataType();
                if (this$dataType == null) {
                    if (other$dataType != null) {
                        return false;
                    }
                } else if (!this$dataType.equals(other$dataType)) {
                    return false;
                }

                if (this.getLength() != other.getLength()) {
                    return false;
                } else if (this.getLimit() != other.getLimit()) {
                    return false;
                } else if (this.getOffset() != other.getOffset()) {
                    return false;
                } else if (this.getTotal() != other.getTotal()) {
                    return false;
                } else {
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
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TaskList;
    }

    public int hashCode() {
        Object $dataType = this.getDataType();
        int result = 1 * 59 + ($dataType == null ? 43 : $dataType.hashCode());
        result = result * 59 + this.getLength();
        result = result * 59 + this.getLimit();
        result = result * 59 + this.getOffset();
        result = result * 59 + this.getTotal();
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "TaskList(dataType=" + this.getDataType() + ", length=" + this.getLength() + ", limit=" + this.getLimit() + ", offset=" + this.getOffset() + ", total=" + this.getTotal() + ", data=" + this.getData() + ")";
    }
}
