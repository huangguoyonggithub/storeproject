package com.hgy.storeproject.vo;

import java.io.Serializable;
import java.util.Objects;

public class CollectVO implements Serializable {
    private Integer tid;
    private Integer gid;
    private Integer uid;
    private Double price;
    private String title;
    private String image;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CollectVO)) return false;
        CollectVO collectVO = (CollectVO) o;
        return Objects.equals(getTid(), collectVO.getTid()) &&
                Objects.equals(getGid(), collectVO.getGid()) &&
                Objects.equals(getUid(), collectVO.getUid()) &&
                Objects.equals(getPrice(), collectVO.getPrice()) &&
                Objects.equals(getTitle(), collectVO.getTitle()) &&
                Objects.equals(getImage(), collectVO.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTid(), getGid(), getUid(), getPrice(), getTitle(), getImage());
    }

    @Override
    public String toString() {
        return "CollectVO{" +
                "tid=" + tid +
                ", gid=" + gid +
                ", uid=" + uid +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
