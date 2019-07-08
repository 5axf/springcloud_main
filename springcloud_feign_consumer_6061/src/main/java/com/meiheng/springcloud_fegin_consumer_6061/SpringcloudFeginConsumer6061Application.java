package com.meiheng.springcloud_fegin_consumer_6061;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringcloudFeginConsumer6061Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFeginConsumer6061Application.class, args);
    }

}
