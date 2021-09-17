package com.huan.threepre.listener.springdemo.multicaster;

import com.huan.threepre.listener.springdemo.event.WeatherEvent;
import com.huan.threepre.listener.springdemo.listener.WeatherListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author YueDong Huan
 * @Date 2021/9/1
 * @Email huanyued@163.com
 * @Version 1.0
 */
public class WeatherEventMulticaster implements EventMulticaster {
    @Autowired
    private List<WeatherListener> listenerList;

    @Override
    public void multicastEvent(WeatherEvent event) {
        System.out.println("事件开始");
        listenerList.forEach(i -> i.onWeatherEvent(event));
        System.out.println("事件结束");
    }

    @Override
    public void addListener(WeatherListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void removeListener(WeatherListener listener) {
        listenerList.remove(listener);
    }
}