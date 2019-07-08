package com.meiheng.springcloud_fegin_consumer_6061.controller;

import com.meiheng.springcloud_fegin_consumer_6061.service.feignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author axf
 * @version 1.0
 * @date 2019/7/5 17:45
 */
@RestController
@RequestMapping("/consumer")
public class feignController {

    @Autowired
    private feignService feignService;

    @RequestMapping("/hello")
    public String feign(){
        String result = feignService.provide("张三");
        return result;
    }
}
