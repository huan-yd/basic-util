package com.huan.threepre.listener.springdemo.multicaster;

import com.huan.threepre.listener.springdemo.event.WeatherEvent;
import com.huan.threepre.listener.springdemo.listener.WeatherListener;

/**
 * @Author YueDong Huan
 * @Date 2021/9/1
 * @Email huanyued@163.com
 * @Version 1.0
 */
// 事件源接口
public interface EventMulticaster {
    void multicastEvent(WeatherEvent event);

    void addListener(WeatherListener listener);

    void removeListener(WeatherListener listener);
}
