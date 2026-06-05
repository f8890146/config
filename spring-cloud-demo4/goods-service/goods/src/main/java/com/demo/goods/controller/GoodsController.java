package com.demo.goods.controller;

import com.demo.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("goods")
@Slf4j
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Value("${server.port}")
    private String port;

    //查询所有商品
    @RequestMapping("all")
    public Object all() {
        return goodsService.findAll();
    }

    //根据ID查询商品
    @RequestMapping("one")
    public Object one(Integer id) {
        log.info("调用商品服务，端口号为：" + port);
        return goodsService.findById(id);
    }
}