package com.hgy.storeproject.entity;

import java.util.Objects;

public class Cart extends BaseEntity{
    private Integer cid;
    private Integer uid;
    private Integer gid;
    private Double price;
    private Integer num;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        if (!super.equals(o)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(getCid(), cart.getCid()) &&
                Objects.equals(getUid(), cart.getUid()) &&
                Objects.equals(getGid(), cart.getGid()) &&
                Objects.equals(getPrice(), cart.getPrice()) &&
                Objects.equals(getNum(), cart.getNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCid(), getUid(), getGid(), getPrice(), getNum());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", gid=" + gid +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
