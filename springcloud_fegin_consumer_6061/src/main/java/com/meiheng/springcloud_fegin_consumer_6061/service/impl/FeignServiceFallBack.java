package com.meiheng.springcloud_fegin_consumer_6061.service.impl;

import com.meiheng.springcloud_fegin_consumer_6061.service.feignService;
import org.springframework.stereotype.Component;

/**
 * @author axf
 * @version 1.0
 * @date 2019/7/11 15:41
 */
@Component
public class FeignServiceFallBack implements feignService {

    /**
     * 该方法就是降级方法
     * @param params
     * @return
     */
    @Override
    public String provide(String params) {
        return "feign降级方法已经启用";
    }
}
