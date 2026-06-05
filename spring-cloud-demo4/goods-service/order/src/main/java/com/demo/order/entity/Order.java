package com.demo.order.entity;


public class Order {
    //订单 ID
    private Integer id;

    public Integer getGoodsId() {
        return goodsId;
    }

    public Order(Integer id, Integer goodsId, String time) {
        this.id = id;
        this.goodsId = goodsId;
        this.time = time;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", time='" + time + '\'' +
                '}';
    }

    //商品 ID
    private Integer goodsId;
    //下单时间
    private String time;
}