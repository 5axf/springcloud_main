package com.meiheng.springcloud_fegin_consumer_6061.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author axf
 * @version 1.0
 * @date 2019/7/5 17:46
 */
@FeignClient(name = "server-provide")
@RequestMapping("/provide")
public interface feignService {

    @RequestMapping("/hello/zhangsan")
    String provide(@PathVariable("params") String params);

}
