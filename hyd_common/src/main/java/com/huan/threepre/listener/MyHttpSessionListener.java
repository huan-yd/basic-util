package com.huan.threepre.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * listener是servlet规范中定义的一种特殊类。
 * 用于监听servletContext、HttpSession和servletRequest等域对象的创建和销毁事件。
 * 监听域对象的属性发生修改的事件。
 * 用于在事件发生前、发生后做一些必要的处理。
 * 其主要可用于以下方面：1、统计在线人数和在线用户2、系统启动时加载初始化信息3、统计网站访问量4、记录用户访问路径。
 *
 * @Author YueDong Huan
 * @Date 2021/8/19
 * @Email huanyued@163.com
 * @Version 1.0
 */
public class MyHttpSessionListener implements HttpSessionListener {

    public static int online = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建session");
        online++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁session");

    }


}
