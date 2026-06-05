package com.demo.hystrixservice.controller;

import com.demo.hystrixservice.service.GoodsService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix")
public class HystrixController {
    @Autowired
    private GoodsService2 goodsService2;
    @GetMapping("/goods2/{id}")
    public Object one2(@PathVariable Integer id) {
        return goodsService2.findById(id);
    }
}
