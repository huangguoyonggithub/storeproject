package com.hgy.storeproject.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order extends BaseEntity implements Serializable {
    private Integer oid;
    private Integer uid;
    private Double totalPrice;
    private Date orderTime;
    private Date payTime;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(getOid(), order.getOid()) &&
                Objects.equals(getUid(), order.getUid()) &&
                Objects.equals(getTotalPrice(), order.getTotalPrice()) &&
                Objects.equals(getOrderTime(), order.getOrderTime()) &&
                Objects.equals(getPayTime(), order.getPayTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOid(), getUid(), getTotalPrice(), getOrderTime(), getPayTime());
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", totalPrice=" + totalPrice +
                ", orderTime=" + orderTime +
                ", payTime=" + payTime +
                '}';
    }
}
