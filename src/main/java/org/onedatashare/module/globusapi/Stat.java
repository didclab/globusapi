//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.onedatashare.module.globusapi;

import java.util.Arrays;
import java.util.Collection;

public class Stat {
    public String id;
    public String name;
    public long size;
    public long time;
    public boolean dir;
    public boolean file;
    public String link;
    public String perm;
    public Stat[] files;
    private transient long total_size;
    private transient long total_num;

    public Stat() {
        this((String)null);
    }

    public Stat(String name) {
        this.total_size = -1L;
        this.total_num = 0L;
        this.name = name;
    }

    public long size() {
        if (this.total_size >= 0L) {
            return this.total_size;
        } else if (!this.dir) {
            return this.total_size = this.size;
        } else {
            long s = this.size;
            if (this.files != null) {
                Stat[] var3 = this.files;
                int var4 = var3.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    Stat f = var3[var5];
                    s += f.dir ? 0L : f.size();
                }
            }

            return this.total_size = s;
        }
    }

    public Stat copy(Stat ft) {
        this.name = ft.name;
        this.size = ft.size;
        this.time = ft.time;
        this.dir = ft.dir;
        this.file = ft.file;
        this.link = ft.link;
        this.perm = ft.perm;
        return this;
    }

    public long count() {
        if (this.total_num > 0L) {
            return this.total_num;
        } else if (!this.dir) {
            return this.total_num = 1L;
        } else {
            long n = 1L;
            if (this.files != null) {
                Stat[] var3 = this.files;
                int var4 = var3.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    Stat f = var3[var5];
                    n += f.count();
                }
            }

            return this.total_num = n;
        }
    }

    public String path() {
        return this.name;
    }

    public Stat setFiles(Collection<Stat> fs) {
        return this.setFiles((Stat[])fs.toArray(new Stat[fs.size()]));
    }

    public Stat setFileNames(Collection<String> fs) {
        return this.setFiles((String[])fs.toArray(new String[fs.size()]));
    }

    public Stat setFiles(Stat[] fs) {
        this.files = fs;
        this.total_size = -1L;
        this.total_num = 0L;
        return this;
    }

    public Stat setFiles(String[] names) {
        if (names == null) {
            this.files = null;
        } else {
            Stat[] stats = new Stat[names.length];

            for(int i = 0; i < stats.length; ++i) {
                stats[i] = new Stat(names[i]);
            }

            this.files = stats;
            this.total_size = -1L;
            this.total_num = 0L;
        }

        return this;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public long getTime() {
        return this.time;
    }

    public boolean isDir() {
        return this.dir;
    }

    public boolean isFile() {
        return this.file;
    }

    public String getLink() {
        return this.link;
    }

    public String getPerm() {
        return this.perm;
    }

    public Stat[] getFiles() {
        return this.files;
    }

    public long getTotal_size() {
        return this.total_size;
    }

    public long getTotal_num() {
        return this.total_num;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setSize(final long size) {
        this.size = size;
    }

    public void setTime(final long time) {
        this.time = time;
    }

    public void setDir(final boolean dir) {
        this.dir = dir;
    }

    public void setFile(final boolean file) {
        this.file = file;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public void setPerm(final String perm) {
        this.perm = perm;
    }

    public void setTotal_size(final long total_size) {
        this.total_size = total_size;
    }

    public void setTotal_num(final long total_num) {
        this.total_num = total_num;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Stat)) {
            return false;
        } else {
            Stat other = (Stat)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label87: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label87;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label87;
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

                if (this.getSize() != other.getSize()) {
                    return false;
                } else if (this.getTime() != other.getTime()) {
                    return false;
                } else if (this.isDir() != other.isDir()) {
                    return false;
                } else if (this.isFile() != other.isFile()) {
                    return false;
                } else {
                    label67: {
                        Object this$link = this.getLink();
                        Object other$link = other.getLink();
                        if (this$link == null) {
                            if (other$link == null) {
                                break label67;
                            }
                        } else if (this$link.equals(other$link)) {
                            break label67;
                        }

                        return false;
                    }

                    Object this$perm = this.getPerm();
                    Object other$perm = other.getPerm();
                    if (this$perm == null) {
                        if (other$perm != null) {
                            return false;
                        }
                    } else if (!this$perm.equals(other$perm)) {
                        return false;
                    }

                    if (!Arrays.deepEquals(this.getFiles(), other.getFiles())) {
                        return false;
                    } else if (this.getTotal_size() != other.getTotal_size()) {
                        return false;
                    } else if (this.getTotal_num() != other.getTotal_num()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Stat;
    }

    public int hashCode() {
        Object $id = this.getId();
        int result = 1 * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        long $size = this.getSize();
        result = result * 59 + (int)($size >>> 32 ^ $size);
        long $time = this.getTime();
        result = result * 59 + (int)($time >>> 32 ^ $time);
        result = result * 59 + (this.isDir() ? 79 : 97);
        result = result * 59 + (this.isFile() ? 79 : 97);
        Object $link = this.getLink();
        result = result * 59 + ($link == null ? 43 : $link.hashCode());
        Object $perm = this.getPerm();
        result = result * 59 + ($perm == null ? 43 : $perm.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getFiles());
        long $total_size = this.getTotal_size();
        result = result * 59 + (int)($total_size >>> 32 ^ $total_size);
        long $total_num = this.getTotal_num();
        result = result * 59 + (int)($total_num >>> 32 ^ $total_num);
        return result;
    }

    public String toString() {
        return "Stat(id=" + this.getId() + ", name=" + this.getName() + ", size=" + this.getSize() + ", time=" + this.getTime() + ", dir=" + this.isDir() + ", file=" + this.isFile() + ", link=" + this.getLink() + ", perm=" + this.getPerm() + ", files=" + Arrays.deepToString(this.getFiles()) + ", total_size=" + this.getTotal_size() + ", total_num=" + this.getTotal_num() + ")";
    }
}
