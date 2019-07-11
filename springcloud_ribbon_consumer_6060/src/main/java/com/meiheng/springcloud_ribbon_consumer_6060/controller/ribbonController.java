package com.meiheng.springcloud_ribbon_consumer_6060.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *  ribbon + restTemplat 的方式调用--自带负载均衡，默认以轮询的方式 -更改负载均衡须在启动类配置
 * @author axf
 * @version 1.0
 * @date 2019/7/5 15:31
 */
//加这个注解 @RestController ，相当于在方法前加 @ResponseBody 注解
@RestController
@RequestMapping("/consumer")
public class ribbonController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 对该方法进行熔断
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @RequestMapping("/hello")
    public String consumer(){
        //链接填提供者的应用名称，第二个参数填返回值的类型，第三个参数 填 参数
        String result = restTemplate.getForObject("http://server-provide/provide/hello/zhangsan",String.class);
        return result;
    }

    /**
     * 该方法的返回值需和原方法的返回值保持一致
     * @return
     */
    public String fallbackMethod(){
        return "服务提供者有问题，fallback已经启动";
    }
}
