package com.huan.threepre.listener.springdemo.run;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author YueDong Huan
 * @Date 2021/9/1
 * @Email huanyued@163.com
 * @Version 1.0
 */
public class WeatherRun {

    @Autowired
    WeatherRunListener weatherRunListener;
    @Test
    public void weatherEventMultica(){
        weatherRunListener.snow();
        weatherRunListener.rain();
    }

}
