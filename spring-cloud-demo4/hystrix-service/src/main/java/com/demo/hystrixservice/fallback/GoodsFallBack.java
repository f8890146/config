package com.demo.hystrixservice.fallback;

import com.demo.hystrixservice.service.GoodsService2;
import org.springframework.stereotype.Component;

@Component
public class GoodsFallBack implements GoodsService2 {
    @Override
    public String findById(Integer id) {
        return "商品服务出现故障,请稍后再试";
    }
}