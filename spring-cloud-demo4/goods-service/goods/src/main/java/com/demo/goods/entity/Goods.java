package com.demo.goods.entity;

public class Goods {
    //商品 ID
    private Integer id;
    //商品名称
    private String name;
    //商品价格
    private Integer price;

    // 无参构造器
    public Goods() {
    }

    // 有参构造器（三个参数）
    public Goods(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // 有参构造器（int 类型参数，兼容你的代码）
    public Goods(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter 方法
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    // Setter 方法
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}