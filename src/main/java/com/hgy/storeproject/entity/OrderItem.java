package com.hgy.storeproject.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderItem extends BaseEntity implements Serializable {
    private Integer mid;
    private Integer oid;
    private Integer gid;
    private Integer uid;
    private String title;
    private String image;
    private Double price;
    private String status;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        if (!super.equals(o)) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(getMid(), orderItem.getMid()) &&
                Objects.equals(getOid(), orderItem.getOid()) &&
                Objects.equals(getGid(), orderItem.getGid()) &&
                Objects.equals(getUid(), orderItem.getUid()) &&
                Objects.equals(getTitle(), orderItem.getTitle()) &&
                Objects.equals(getImage(), orderItem.getImage()) &&
                Objects.equals(getPrice(), orderItem.getPrice()) &&
                Objects.equals(getStatus(), orderItem.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMid(), getOid(), getGid(), getUid(), getTitle(), getImage(), getPrice(), getStatus());
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "mid=" + mid +
                ", oid=" + oid +
                ", gid=" + gid +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
