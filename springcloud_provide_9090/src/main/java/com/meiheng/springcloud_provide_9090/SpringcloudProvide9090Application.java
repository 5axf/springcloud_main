package com.meiheng.springcloud_provide_9090;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudProvide9090Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvide9090Application.class, args);
    }

}
