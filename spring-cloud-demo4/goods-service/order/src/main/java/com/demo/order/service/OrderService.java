package com.demo.order.service;

import java.util.List;

public interface OrderService {
    //查询所有订单
    List findAll();

    //根据 ID查询订单
    Object findById(Integer id);
}