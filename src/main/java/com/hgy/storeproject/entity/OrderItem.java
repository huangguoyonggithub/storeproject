package com.hgy.storeproject.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderItem extends BaseEntity implements Serializable {
    private Integer id;
    private Integer oid;
    private Integer gid;
    private String title;
    private String image;
    private Double price;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return Objects.equals(getId(), orderItem.getId()) &&
                Objects.equals(getOid(), orderItem.getOid()) &&
                Objects.equals(getGid(), orderItem.getGid()) &&
                Objects.equals(getTitle(), orderItem.getTitle()) &&
                Objects.equals(getImage(), orderItem.getImage()) &&
                Objects.equals(getPrice(), orderItem.getPrice()) &&
                Objects.equals(getStatus(), orderItem.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getOid(), getGid(), getTitle(), getImage(), getPrice(), getStatus());
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", oid=" + oid +
                ", gid=" + gid +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
