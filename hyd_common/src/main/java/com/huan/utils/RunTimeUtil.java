package com.huan.utils;

import org.apache.commons.lang3.time.StopWatch;

import java.time.Duration;
import java.time.Instant;

/**
 * 代码运行时间工具类
 * @Author YueDong Huan
 * @Date 2021/8/18
 * @Email huanyued@163.com
 * @Version 1.0
 */
public class RunTimeUtil {

    public void currentTimeMillis () {
        long start = System.currentTimeMillis();
        // 业务逻辑代码...
        long end = System.currentTimeMillis();
        long timeElapsed = end - start; // 单位为毫秒
    }

    public void epoch () {
        Instant start = Instant.now();
        // 业务逻辑代码...
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis(); // 单位为毫秒
    }

    public void stopWatch () {
        StopWatch watch = new StopWatch();
        watch.start();
        // 业务逻辑代码...
        watch.stop();
        System.out.println("Time Elapsed: " + watch.getTime() + "ms"); // 单位为毫秒
    }




}
