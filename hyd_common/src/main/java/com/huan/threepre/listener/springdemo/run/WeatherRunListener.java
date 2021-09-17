package com.huan.threepre.listener.springdemo.run;

import com.huan.threepre.listener.springdemo.event.RainEvent;
import com.huan.threepre.listener.springdemo.event.SnowEvent;
import com.huan.threepre.listener.springdemo.multicaster.WeatherEventMulticaster;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author YueDong Huan
 * @Date 2021/9/1
 * @Email huanyued@163.com
 * @Version 1.0
 */
public class WeatherRunListener {
    @Autowired
    private WeatherEventMulticaster weatherEventMulticaster;

    public void snow(){
        weatherEventMulticaster.multicastEvent(new SnowEvent());
    }

    public void rain(){
        weatherEventMulticaster.multicastEvent(new RainEvent());
    }
}
