package com.huan.threepre.listener.springdemo.event;

/**
 * @Author YueDong Huan
 * @Date 2021/9/1
 * @Email huanyued@163.com
 * @Version 1.0
 */
// 下雨事件
public class RainEvent extends WeatherEvent{
    @Override
    public String getWeather() {
        return "下雨";
    }
}
