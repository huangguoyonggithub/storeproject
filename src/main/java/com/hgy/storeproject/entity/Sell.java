package com.hgy.storeproject.entity;

import java.io.Serializable;
import java.util.Objects;

public class Sell extends BaseEntity implements Serializable {
    private Integer sid;
    private Integer uid;
    private Integer gid;
    private Integer categoryId;
    private String goodType;
    private String title;
    private double price;
    private double prices;
    private String image;
    private String status;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sell)) return false;
        if (!super.equals(o)) return false;
        Sell sell = (Sell) o;
        return Double.compare(sell.getPrice(), getPrice()) == 0 &&
                Double.compare(sell.getPrices(), getPrices()) == 0 &&
                Objects.equals(getSid(), sell.getSid()) &&
                Objects.equals(getUid(), sell.getUid()) &&
                Objects.equals(getGid(), sell.getGid()) &&
                Objects.equals(getCategoryId(), sell.getCategoryId()) &&
                Objects.equals(getGoodType(), sell.getGoodType()) &&
                Objects.equals(getTitle(), sell.getTitle()) &&
                Objects.equals(getImage(), sell.getImage()) &&
                Objects.equals(getStatus(), sell.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSid(), getUid(), getGid(), getCategoryId(), getGoodType(), getTitle(), getPrice(), getPrices(), getImage(), getStatus());
    }

    @Override
    public String toString() {
        return "Sell{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", gid=" + gid +
                ", categoryId=" + categoryId +
                ", goodType='" + goodType + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", prices=" + prices +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
