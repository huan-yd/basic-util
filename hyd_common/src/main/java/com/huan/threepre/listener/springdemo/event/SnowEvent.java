package com.huan.threepre.listener.springdemo.event;

/**
 * @Author YueDong Huan
 * @Date 2021/9/1
 * @Email huanyued@163.com
 * @Version 1.0
 */
// 下雪事件
public class SnowEvent extends  WeatherEvent {
    @Override
    public String getWeather() {
        return "下雪";
    }
}
