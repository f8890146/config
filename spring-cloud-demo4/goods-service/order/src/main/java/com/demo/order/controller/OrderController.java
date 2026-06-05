package com.demo.order.controller;

import com.demo.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    //查询所有订单
    @RequestMapping("all")
    public Object all () {
        return orderService.findAll();
    }
//根据ID查询订单
        @RequestMapping("one")
        public Object one(Integer id){
            return orderService.findById(id);
        }
}