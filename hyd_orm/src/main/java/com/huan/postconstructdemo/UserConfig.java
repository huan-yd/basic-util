package com.huan.postconstructdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author YueDong Huan
 * @Date 2021/9/24
 * @Email huanyued@163.com
 * @Version 1.0
 */
@Configuration
public class UserConfig {
    @Bean
    public Chicken putUser(){
        Chicken chinken = new Chicken();
        chinken.setName("吮指鸡块");
        return chinken;
    }
}
