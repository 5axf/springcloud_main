package com.meiheng.springcloud_provide_9091.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author axf
 * @version 1.0
 * @date 2019/7/5 12:03
 */
@RestController
@RequestMapping("/provide")
public class provideController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello/{params}")
    public String provide(@PathVariable("params") String params){
        return "成功调用了提供者，提供者的端口是："+port+",接收到的参数是："+params;
    }
}
