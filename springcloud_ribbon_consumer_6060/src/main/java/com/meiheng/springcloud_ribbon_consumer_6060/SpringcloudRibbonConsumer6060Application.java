package com.meiheng.springcloud_ribbon_consumer_6060;

import com.meiheng.springcloud_ribbon_consumer_6060.ribbon.NoCompend;
import com.meiheng.springcloud_ribbon_consumer_6060.ribbon.RibbonConfig;
import com.meiheng.springcloud_ribbon_consumer_6060.ribbon.RibbonConfig2;
import com.netflix.loadbalancer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//启动熔断器
@EnableHystrix
//设置不同的服务用不同的轮询策略
@RibbonClients({
        @RibbonClient(name = "server-provide",configuration = RibbonConfig.class),
        @RibbonClient(name = "第二个微服务名称",configuration = RibbonConfig2.class)
})
//配置扫描黑名单，配置了的spring将不会扫描
@ComponentScan(excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,value = NoCompend.class))
public class SpringcloudRibbonConsumer6060Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRibbonConsumer6060Application.class, args);
    }

    /**
     * 获得restTemplate @Bean
     * 加载负载均衡 @LoadBalanced - 只有一个提供者也需要加这个注解
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 设置负载均衡的策略 -- 全局的负载均衡策略
     * RoundRobinRule 轮询
     * RandomRule 随机
     * WeightedResponseTimeRule 权重
     * RetryRule 轮询的基础上加上重试机制
     * BestAvailableRule 选择一个并发最小的
     * @return
     */
    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
