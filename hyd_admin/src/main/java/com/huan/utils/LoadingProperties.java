package com.huan.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.ServiceLoader;

/**
 * 加载配置文件
 *
 * @Author YueDong Huan
 * @Date 2021/8/24
 * @Email huanyued@163.com
 * @Version 1.0
 */
public class LoadingProperties {

    private Properties contextConfig = new Properties();

    public void doLoadConfig(String contextConfigLocation) {
        // 直接从ClassPath下找spring的配置文件
        // 相当于把application.properties文件读到了内存中(contextConfig这个对象)
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据接口从METAINFO加载实现类
     *
     * @param service: 接口类
     * @return void
     * @author YueDong Huan
     * @date 2021/9/17 11:12
     */
    public <S> void doLoadMetaInfo(Class<S> service) {
        ServiceLoader<S> load = ServiceLoader.load(service);
        Iterator<S> iterator = load.iterator();
        while (iterator.hasNext()) {
            S s = iterator.next();
        }
    }


}
