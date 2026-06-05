package com.demo.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class GoodsListApplication {

    public static void main(String[] args) {

        SpringApplication.run(GoodsListApplication.class, args);
    }

}
