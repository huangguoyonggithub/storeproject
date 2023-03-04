package com.hgy.storeproject.entity;

import java.io.Serializable;
import java.util.Objects;

public class Collect extends BaseEntity implements Serializable {
    private Integer tid;
    private Integer gid;
    private Integer uid;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Collect)) return false;
        if (!super.equals(o)) return false;
        Collect collect = (Collect) o;
        return Objects.equals(getTid(), collect.getTid()) &&
                Objects.equals(getGid(), collect.getGid()) &&
                Objects.equals(getUid(), collect.getUid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTid(), getGid(), getUid());
    }

    @Override
    public String toString() {
        return "Collect{" +
                "tid=" + tid +
                ", gid=" + gid +
                ", uid=" + uid +
                '}';
    }
}
