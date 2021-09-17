package com.huan.threepre.listener.springdemo.listener;

import com.huan.threepre.listener.springdemo.event.SnowEvent;
import com.huan.threepre.listener.springdemo.event.WeatherEvent;

/**
 * @Author YueDong Huan
 * @Date 2021/9/1
 * @Email huanyued@163.com
 * @Version 1.0
 */
// 监听器两个实现
// 下雪事件监听器
public class SnowListener implements WeatherListener{
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof SnowEvent){
            System.out.println("执行事件的方法：" + event.getWeather());
        }
    }
}
