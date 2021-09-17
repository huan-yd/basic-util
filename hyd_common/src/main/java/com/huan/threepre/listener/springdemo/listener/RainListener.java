package com.huan.threepre.listener.springdemo.listener;

import com.huan.threepre.listener.springdemo.event.RainEvent;
import com.huan.threepre.listener.springdemo.event.WeatherEvent;

/**
 * @Author YueDong Huan
 * @Date 2021/9/1
 * @Email huanyued@163.com
 * @Version 1.0
 */
// 下雨事件监听器
public class RainListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof RainEvent) {
            System.out.println("执行事件的方法" + event.getWeather());
        }
    }
}
