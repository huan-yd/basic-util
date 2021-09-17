package com.huan.threepre.listener.springdemo.listener;

import com.huan.threepre.listener.springdemo.event.RainEvent;
import com.huan.threepre.listener.springdemo.event.SnowEvent;
import com.huan.threepre.listener.springdemo.event.WeatherEvent;

/**
 * @Author YueDong Huan
 * @Date 2021/9/1
 * @Email huanyued@163.com
 * @Version 1.0
 */
// 监听器接口
public interface WeatherListener {
    /**
     *  监听到天气时，做出的行为
     * @param event
     */
    void onWeatherEvent(WeatherEvent event);
}
