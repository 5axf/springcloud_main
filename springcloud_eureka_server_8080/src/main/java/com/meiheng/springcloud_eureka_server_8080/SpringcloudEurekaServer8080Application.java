package com.meiheng.springcloud_eureka_server_8080;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用springCloud的组件规律
 * 1.添加maven依赖
 * 2.在启动类中添加@Enablexxx注解
 * 3.修改application文件
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEurekaServer8080Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaServer8080Application.class, args);
    }

}
