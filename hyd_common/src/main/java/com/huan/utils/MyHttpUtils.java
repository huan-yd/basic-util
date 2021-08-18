package com.huan.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 关于分析http请求的工具类
 * @Author YueDong Huan
 * @Date 2021/7/12
 * @Email huanyued@163.com
 */
public class MyHttpUtils {

    public Object getIp(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("ip" ,request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + request.getRequestURI());
        return map;
    }

}
