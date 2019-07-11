package com.meiheng.springcloud_zuul_10000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulServer
public class SpringcloudZuul10000Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuul10000Application.class, args);
    }

}
