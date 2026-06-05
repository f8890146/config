package com.demo.goods.service.impl;


import com.demo.goods.entity.Goods;
import com.demo.goods.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    //初始化商品集合
    private static final Map<Integer, Goods> goodsMap = new HashMap<>();
    static {
        Goods goods1 = new Goods(1, "}#l", 1000);
        Goods goods2 = new Goods(2, "", 3000);
        Goods goods3 = new Goods(3, "/l", 2000);
        goodsMap.put(goods1.getId(), goods1);
        goodsMap.put(goods2.getId(), goods2);
        goodsMap.put(goods3.getId(), goods3);
    }

    @Override
    public List<Goods> findAll() {
        return new ArrayList<>(goodsMap.values());
    }

    @Override
    public Goods findById(Integer id){
        return goodsMap.get(id);
    }
}