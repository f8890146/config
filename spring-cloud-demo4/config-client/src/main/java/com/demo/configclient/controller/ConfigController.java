package com.demo.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class ConfigController {

    @Value("${mylog.version}")
    private String version;

    @GetMapping("/getVersion")
    public String getVersion() {
        return "来自配置中心的版本信息: " + version;
    }
}