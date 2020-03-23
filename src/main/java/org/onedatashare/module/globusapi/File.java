package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class File {
    @JsonProperty("DATA_TYPE")
    String dataType;
    @JsonProperty("name")
    String name;
    @JsonProperty("type")
    String type;
    @JsonProperty("link_target")
    String linkTarget;
    @JsonProperty("symlink_supported")
    Boolean symlinkSupported;
    @JsonProperty("user")
    String user;
    @JsonProperty("link_user")
    String linkUser;
    @JsonProperty("group")
    String group;
    @JsonProperty("link_group")
    String linkGroup;
    @JsonProperty("permissions")
    String permissions;
    @JsonProperty("last_modified")
    String lastModified;
    @JsonProperty("link_last_modified")
    String linkLastModified;
    @JsonProperty("size")
    Long size;
    @JsonProperty("link_size")
    Long linkSize;

    public File() {
    }

    public String getDataType() {
        return this.dataType;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getLinkTarget() {
        return this.linkTarget;
    }

    public Boolean getSymlinkSupported() {
        return this.symlinkSupported;
    }

    public String getUser() {
        return this.user;
    }

    public String getLinkUser() {
        return this.linkUser;
    }

    public String getGroup() {
        return this.group;
    }

    public String getLinkGroup() {
        return this.linkGroup;
    }

    public String getPermissions() {
        return this.permissions;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public String getLinkLastModified() {
        return this.linkLastModified;
    }

    public Long getSize() {
        return this.size;
    }

    public Long getLinkSize() {
        return this.linkSize;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setLinkTarget(final String linkTarget) {
        this.linkTarget = linkTarget;
    }

    public void setSymlinkSupported(final Boolean symlinkSupported) {
        this.symlinkSupported = symlinkSupported;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public void setLinkUser(final String linkUser) {
        this.linkUser = linkUser;
    }

    public void setGroup(final String group) {
        this.group = group;
    }

    public void setLinkGroup(final String linkGroup) {
        this.linkGroup = linkGroup;
    }

    public void setPermissions(final String permissions) {
        this.permissions = permissions;
    }

    public void setLastModified(final String lastModified) {
        this.lastModified = lastModified;
    }

    public void setLinkLastModified(final String linkLastModified) {
        this.linkLastModified = linkLastModified;
    }

    public void setSize(final Long size) {
        this.size = size;
    }

    public void setLinkSize(final Long linkSize) {
        this.linkSize = linkSize;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof File)) {
            return false;
        } else {
            File other = (File)o;
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

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
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

                label158: {
                    Object this$linkTarget = this.getLinkTarget();
                    Object other$linkTarget = other.getLinkTarget();
                    if (this$linkTarget == null) {
                        if (other$linkTarget == null) {
                            break label158;
                        }
                    } else if (this$linkTarget.equals(other$linkTarget)) {
                        break label158;
                    }

                    return false;
                }

                label151: {
                    Object this$symlinkSupported = this.getSymlinkSupported();
                    Object other$symlinkSupported = other.getSymlinkSupported();
                    if (this$symlinkSupported == null) {
                        if (other$symlinkSupported == null) {
                            break label151;
                        }
                    } else if (this$symlinkSupported.equals(other$symlinkSupported)) {
                        break label151;
                    }

                    return false;
                }

                Object this$user = this.getUser();
                Object other$user = other.getUser();
                if (this$user == null) {
                    if (other$user != null) {
                        return false;
                    }
                } else if (!this$user.equals(other$user)) {
                    return false;
                }

                label137: {
                    Object this$linkUser = this.getLinkUser();
                    Object other$linkUser = other.getLinkUser();
                    if (this$linkUser == null) {
                        if (other$linkUser == null) {
                            break label137;
                        }
                    } else if (this$linkUser.equals(other$linkUser)) {
                        break label137;
                    }

                    return false;
                }

                label130: {
                    Object this$group = this.getGroup();
                    Object other$group = other.getGroup();
                    if (this$group == null) {
                        if (other$group == null) {
                            break label130;
                        }
                    } else if (this$group.equals(other$group)) {
                        break label130;
                    }

                    return false;
                }

                Object this$linkGroup = this.getLinkGroup();
                Object other$linkGroup = other.getLinkGroup();
                if (this$linkGroup == null) {
                    if (other$linkGroup != null) {
                        return false;
                    }
                } else if (!this$linkGroup.equals(other$linkGroup)) {
                    return false;
                }

                Object this$permissions = this.getPermissions();
                Object other$permissions = other.getPermissions();
                if (this$permissions == null) {
                    if (other$permissions != null) {
                        return false;
                    }
                } else if (!this$permissions.equals(other$permissions)) {
                    return false;
                }

                label109: {
                    Object this$lastModified = this.getLastModified();
                    Object other$lastModified = other.getLastModified();
                    if (this$lastModified == null) {
                        if (other$lastModified == null) {
                            break label109;
                        }
                    } else if (this$lastModified.equals(other$lastModified)) {
                        break label109;
                    }

                    return false;
                }

                label102: {
                    Object this$linkLastModified = this.getLinkLastModified();
                    Object other$linkLastModified = other.getLinkLastModified();
                    if (this$linkLastModified == null) {
                        if (other$linkLastModified == null) {
                            break label102;
                        }
                    } else if (this$linkLastModified.equals(other$linkLastModified)) {
                        break label102;
                    }

                    return false;
                }

                Object this$size = this.getSize();
                Object other$size = other.getSize();
                if (this$size == null) {
                    if (other$size != null) {
                        return false;
                    }
                } else if (!this$size.equals(other$size)) {
                    return false;
                }

                Object this$linkSize = this.getLinkSize();
                Object other$linkSize = other.getLinkSize();
                if (this$linkSize == null) {
                    if (other$linkSize != null) {
                        return false;
                    }
                } else if (!this$linkSize.equals(other$linkSize)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof File;
    }

    public int hashCode() {
        Object $dataType = this.getDataType();
        int result = 1 * 59 + ($dataType == null ? 43 : $dataType.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $linkTarget = this.getLinkTarget();
        result = result * 59 + ($linkTarget == null ? 43 : $linkTarget.hashCode());
        Object $symlinkSupported = this.getSymlinkSupported();
        result = result * 59 + ($symlinkSupported == null ? 43 : $symlinkSupported.hashCode());
        Object $user = this.getUser();
        result = result * 59 + ($user == null ? 43 : $user.hashCode());
        Object $linkUser = this.getLinkUser();
        result = result * 59 + ($linkUser == null ? 43 : $linkUser.hashCode());
        Object $group = this.getGroup();
        result = result * 59 + ($group == null ? 43 : $group.hashCode());
        Object $linkGroup = this.getLinkGroup();
        result = result * 59 + ($linkGroup == null ? 43 : $linkGroup.hashCode());
        Object $permissions = this.getPermissions();
        result = result * 59 + ($permissions == null ? 43 : $permissions.hashCode());
        Object $lastModified = this.getLastModified();
        result = result * 59 + ($lastModified == null ? 43 : $lastModified.hashCode());
        Object $linkLastModified = this.getLinkLastModified();
        result = result * 59 + ($linkLastModified == null ? 43 : $linkLastModified.hashCode());
        Object $size = this.getSize();
        result = result * 59 + ($size == null ? 43 : $size.hashCode());
        Object $linkSize = this.getLinkSize();
        result = result * 59 + ($linkSize == null ? 43 : $linkSize.hashCode());
        return result;
    }

    public String toString() {
        return "File(dataType=" + this.getDataType() + ", name=" + this.getName() + ", type=" + this.getType() + ", linkTarget=" + this.getLinkTarget() + ", symlinkSupported=" + this.getSymlinkSupported() + ", user=" + this.getUser() + ", linkUser=" + this.getLinkUser() + ", group=" + this.getGroup() + ", linkGroup=" + this.getLinkGroup() + ", permissions=" + this.getPermissions() + ", lastModified=" + this.getLastModified() + ", linkLastModified=" + this.getLinkLastModified() + ", size=" + this.getSize() + ", linkSize=" + this.getLinkSize() + ")";
    }
}

