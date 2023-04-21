package com.hgy.storeproject.entity;

import java.io.Serializable;
import java.util.Objects;

public class Warehouse extends BaseEntity implements Serializable {
    private Integer wid;
    private Integer uid;
    private Integer gid;
    private Double price;
    private String title;
    private String image;
    private String status;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warehouse)) return false;
        if (!super.equals(o)) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(getWid(), warehouse.getWid()) &&
                Objects.equals(getUid(), warehouse.getUid()) &&
                Objects.equals(getGid(), warehouse.getGid()) &&
                Objects.equals(getPrice(), warehouse.getPrice()) &&
                Objects.equals(getTitle(), warehouse.getTitle()) &&
                Objects.equals(getImage(), warehouse.getImage()) &&
                Objects.equals(getStatus(), warehouse.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWid(), getUid(), getGid(), getPrice(), getTitle(), getImage(), getStatus());
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "wid=" + wid +
                ", uid=" + uid +
                ", gid=" + gid +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
