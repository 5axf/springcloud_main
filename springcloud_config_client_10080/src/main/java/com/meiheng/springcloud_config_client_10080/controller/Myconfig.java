package com.meiheng.springcloud_config_client_10080.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author axf
 * @version 1.0
 * @date 2019/8/6 11:01
 */
@RestController
@RequestMapping("/config")
public class Myconfig {

    @Value("${com.name}")
    private String name;

    @RequestMapping("/test")
    public String test(){
        return "从配置中心获取到的配置信息：" + name;
    }
}
