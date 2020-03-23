package org.onedatashare.module.globusapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class EndPoint {
    private String id;
    private String name;
    @JsonProperty("canonical_name")
    private String canonicalName;
    @JsonProperty("expire_time")
    private String expiryTime;
    @JsonProperty("expires_in")
    private String expiresIn;
    @JsonProperty("myproxy_dn")
    private String myProxyDomainName;
    @JsonProperty("myproxy_server")
    private String myProxyServer;
    private String activated;
    @JsonProperty("DATA")
    private List<EndPoint.Server> data;

    public EndPoint() {
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCanonicalName() {
        return this.canonicalName;
    }

    public String getExpiryTime() {
        return this.expiryTime;
    }

    public String getExpiresIn() {
        return this.expiresIn;
    }

    public String getMyProxyDomainName() {
        return this.myProxyDomainName;
    }

    public String getMyProxyServer() {
        return this.myProxyServer;
    }

    public String getActivated() {
        return this.activated;
    }

    public List<EndPoint.Server> getData() {
        return this.data;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setCanonicalName(final String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public void setExpiryTime(final String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public void setExpiresIn(final String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setMyProxyDomainName(final String myProxyDomainName) {
        this.myProxyDomainName = myProxyDomainName;
    }

    public void setMyProxyServer(final String myProxyServer) {
        this.myProxyServer = myProxyServer;
    }

    public void setActivated(final String activated) {
        this.activated = activated;
    }

    public void setData(final List<EndPoint.Server> data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof EndPoint)) {
            return false;
        } else {
            EndPoint other = (EndPoint)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label119: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label119;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label119;
                    }

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

                label105: {
                    Object this$canonicalName = this.getCanonicalName();
                    Object other$canonicalName = other.getCanonicalName();
                    if (this$canonicalName == null) {
                        if (other$canonicalName == null) {
                            break label105;
                        }
                    } else if (this$canonicalName.equals(other$canonicalName)) {
                        break label105;
                    }

                    return false;
                }

                Object this$expiryTime = this.getExpiryTime();
                Object other$expiryTime = other.getExpiryTime();
                if (this$expiryTime == null) {
                    if (other$expiryTime != null) {
                        return false;
                    }
                } else if (!this$expiryTime.equals(other$expiryTime)) {
                    return false;
                }

                label91: {
                    Object this$expiresIn = this.getExpiresIn();
                    Object other$expiresIn = other.getExpiresIn();
                    if (this$expiresIn == null) {
                        if (other$expiresIn == null) {
                            break label91;
                        }
                    } else if (this$expiresIn.equals(other$expiresIn)) {
                        break label91;
                    }

                    return false;
                }

                Object this$myProxyDomainName = this.getMyProxyDomainName();
                Object other$myProxyDomainName = other.getMyProxyDomainName();
                if (this$myProxyDomainName == null) {
                    if (other$myProxyDomainName != null) {
                        return false;
                    }
                } else if (!this$myProxyDomainName.equals(other$myProxyDomainName)) {
                    return false;
                }

                label77: {
                    Object this$myProxyServer = this.getMyProxyServer();
                    Object other$myProxyServer = other.getMyProxyServer();
                    if (this$myProxyServer == null) {
                        if (other$myProxyServer == null) {
                            break label77;
                        }
                    } else if (this$myProxyServer.equals(other$myProxyServer)) {
                        break label77;
                    }

                    return false;
                }

                label70: {
                    Object this$activated = this.getActivated();
                    Object other$activated = other.getActivated();
                    if (this$activated == null) {
                        if (other$activated == null) {
                            break label70;
                        }
                    } else if (this$activated.equals(other$activated)) {
                        break label70;
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EndPoint;
    }

    public int hashCode() {
        Object $id = this.getId();
        int result = 1 * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $canonicalName = this.getCanonicalName();
        result = result * 59 + ($canonicalName == null ? 43 : $canonicalName.hashCode());
        Object $expiryTime = this.getExpiryTime();
        result = result * 59 + ($expiryTime == null ? 43 : $expiryTime.hashCode());
        Object $expiresIn = this.getExpiresIn();
        result = result * 59 + ($expiresIn == null ? 43 : $expiresIn.hashCode());
        Object $myProxyDomainName = this.getMyProxyDomainName();
        result = result * 59 + ($myProxyDomainName == null ? 43 : $myProxyDomainName.hashCode());
        Object $myProxyServer = this.getMyProxyServer();
        result = result * 59 + ($myProxyServer == null ? 43 : $myProxyServer.hashCode());
        Object $activated = this.getActivated();
        result = result * 59 + ($activated == null ? 43 : $activated.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "EndPoint(id=" + this.getId() + ", name=" + this.getName() + ", canonicalName=" + this.getCanonicalName() + ", expiryTime=" + this.getExpiryTime() + ", expiresIn=" + this.getExpiresIn() + ", myProxyDomainName=" + this.getMyProxyDomainName() + ", myProxyServer=" + this.getMyProxyServer() + ", activated=" + this.getActivated() + ", data=" + this.getData() + ")";
    }

    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    public static class Server {
        @JsonProperty("hostname")
        private String hostName;
        @JsonProperty("uri")
        private String uri;
        private String port;
        private String scheme;

        public Server() {
        }
    }
}
