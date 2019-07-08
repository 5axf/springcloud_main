package com.meiheng.springcloud_ribbon_consumer_6060.ribbon;

import java.lang.annotation.*;

/**
 * 自定义注解--告诉spring不要扫描被注解的类
 * @author axf
 * @version 1.0
 * @date 2019/7/5 17:05
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NoCompend {
}
