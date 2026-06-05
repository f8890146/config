package com.demo.hystrixservice.service.impl;

import com.demo.hystrixservice.service.GoodsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    // 出现故障则进行服务熔断，并进行回退降级处理
    @HystrixCommand(fallbackMethod = "goodsFallBack")
    public String findGoodsById(Integer id) {
        return restTemplate.getForObject("http://GOODS2/goods/one?id=" + id, String.class);
    }

    public String goodsFallBack(Integer id) {
        return "商品服务出现故障，请稍后再试";
    }
}