package com.hgy.storeproject.entity;

import java.io.Serializable;
import java.util.Objects;

public class Good extends BaseEntity implements Serializable {
    private Integer gid;
    private Integer categoryId;
    private String goodType;
    private String title;
    private double price;
    private double prices;
    private Integer num;
    private String image;
    private String status;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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
        if (!(o instanceof Good)) return false;
        if (!super.equals(o)) return false;
        Good good = (Good) o;
        return Double.compare(good.getPrice(), getPrice()) == 0 &&
                Double.compare(good.getPrices(), getPrices()) == 0 &&
                Objects.equals(getGid(), good.getGid()) &&
                Objects.equals(getCategoryId(), good.getCategoryId()) &&
                Objects.equals(getGoodType(), good.getGoodType()) &&
                Objects.equals(getTitle(), good.getTitle()) &&
                Objects.equals(getNum(), good.getNum()) &&
                Objects.equals(getImage(), good.getImage()) &&
                Objects.equals(getStatus(), good.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGid(), getCategoryId(), getGoodType(), getTitle(), getPrice(), getPrices(), getNum(), getImage(), getStatus());
    }

    @Override
    public String toString() {
        return "Good{" +
                "gid=" + gid +
                ", categoryId=" + categoryId +
                ", goodType='" + goodType + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", prices=" + prices +
                ", num=" + num +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
