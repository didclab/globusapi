package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class EndPointList {
    @JsonProperty("DATA_TYPE")
    private String dataType;
    @JsonProperty("has_next_page")
    private boolean hasNextPage;
    private Integer limit;
    private Integer offset;
    @JsonProperty("DATA")
    private List<EndPoint> data;

    public EndPointList() {
    }

    public String getDataType() {
        return this.dataType;
    }

    public boolean isHasNextPage() {
        return this.hasNextPage;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public List<EndPoint> getData() {
        return this.data;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }

    public void setHasNextPage(final boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public void setLimit(final Integer limit) {
        this.limit = limit;
    }

    public void setOffset(final Integer offset) {
        this.offset = offset;
    }

    public void setData(final List<EndPoint> data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof EndPointList)) {
            return false;
        } else {
            EndPointList other = (EndPointList)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label63: {
                    Object this$dataType = this.getDataType();
                    Object other$dataType = other.getDataType();
                    if (this$dataType == null) {
                        if (other$dataType == null) {
                            break label63;
                        }
                    } else if (this$dataType.equals(other$dataType)) {
                        break label63;
                    }

                    return false;
                }

                if (this.isHasNextPage() != other.isHasNextPage()) {
                    return false;
                } else {
                    label55: {
                        Object this$limit = this.getLimit();
                        Object other$limit = other.getLimit();
                        if (this$limit == null) {
                            if (other$limit == null) {
                                break label55;
                            }
                        } else if (this$limit.equals(other$limit)) {
                            break label55;
                        }

                        return false;
                    }

                    Object this$offset = this.getOffset();
                    Object other$offset = other.getOffset();
                    if (this$offset == null) {
                        if (other$offset != null) {
                            return false;
                        }
                    } else if (!this$offset.equals(other$offset)) {
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
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EndPointList;
    }

    public int hashCode() {
        Object $dataType = this.getDataType();
        int result = 1 * 59 + ($dataType == null ? 43 : $dataType.hashCode());
        result = result * 59 + (this.isHasNextPage() ? 79 : 97);
        Object $limit = this.getLimit();
        result = result * 59 + ($limit == null ? 43 : $limit.hashCode());
        Object $offset = this.getOffset();
        result = result * 59 + ($offset == null ? 43 : $offset.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "EndPointList(dataType=" + this.getDataType() + ", hasNextPage=" + this.isHasNextPage() + ", limit=" + this.getLimit() + ", offset=" + this.getOffset() + ", data=" + this.getData() + ")";
    }
}
