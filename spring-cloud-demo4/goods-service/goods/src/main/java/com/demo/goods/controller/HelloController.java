package com.demo.goods.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * url: localhost:8081/demo/hello
 */
@Controller
@RequestMapping("demo")
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "hello-goods";
    }

}
