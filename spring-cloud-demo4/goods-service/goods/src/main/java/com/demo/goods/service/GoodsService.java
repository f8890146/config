package com.demo.goods.service;

import com.demo.goods.entity.Goods;

import java.util.List;

public interface GoodsService {
    //查询所有商品
    List<Goods> findAll();
    //根据 ID查询商品
    Goods findById(Integer id);

}