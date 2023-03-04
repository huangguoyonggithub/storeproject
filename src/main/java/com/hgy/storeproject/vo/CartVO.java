package com.hgy.storeproject.vo;

import java.io.Serializable;
import java.util.Objects;

public class CartVO implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer gid;
    private Double price;
    private Integer num;
    private String title;
    private String image;

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
        if (!(o instanceof CartVO)) return false;
        CartVO cartVO = (CartVO) o;
        return Objects.equals(getCid(), cartVO.getCid()) &&
                Objects.equals(getUid(), cartVO.getUid()) &&
                Objects.equals(getGid(), cartVO.getGid()) &&
                Objects.equals(getPrice(), cartVO.getPrice()) &&
                Objects.equals(getNum(), cartVO.getNum()) &&
                Objects.equals(getTitle(), cartVO.getTitle()) &&
                Objects.equals(getImage(), cartVO.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCid(), getUid(), getGid(), getPrice(), getNum(), getTitle(), getImage());
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", gid=" + gid +
                ", price=" + price +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
