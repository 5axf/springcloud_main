package com.meiheng.springcloud_ribbon_consumer_6060.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author axf
 * @version 1.0
 * @date 2019/7/5 16:55
 */
@Configuration
//自定义注解
@NoCompend
public class RibbonConfig {
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
