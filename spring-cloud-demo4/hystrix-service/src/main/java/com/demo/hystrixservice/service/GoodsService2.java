package com.demo.hystrixservice.service;

import com.demo.hystrixservice.fallback.GoodsFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "GOODS2", fallback = GoodsFallBack.class)  // 改为 GOODS2
public interface GoodsService2 {

    @GetMapping("/goods/one")  // 注意：这里的路径要和 goods-service 一致
    String findById(@RequestParam("id") Integer id);
}