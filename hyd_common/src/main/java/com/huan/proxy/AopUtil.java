package com.huan.proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author YueDong Huan
 * @Date 2021/8/18
 * @Email huanyued@163.com
 * @Version 1.0
 */
public class AopUtil {

    public static void main(String[] args) {
        //代理的真实对象
        Object object = new Object();

        /**
         * InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
         * 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用.
         * 即：要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法
         */
        InvocationHandler handler = new InvocationHandlerImpl(object);

        ClassLoader loader = handler.getClass().getClassLoader();
        Class[] interfaces = object.getClass().getInterfaces();
        /**
         * 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
         */
        Object proxyObject = Proxy.newProxyInstance(loader, interfaces, handler);

        System.out.println("动态代理对象的类型：" + proxyObject.getClass().getName());

        // 将生成的字节码保存到本地，
        createProxyClassFile();
    }

    private static void createProxyClassFile() {
        String name = "XXXXX";
        byte[] data = null;//ProxyGenerator.generateProxyClass(name,new Class[]{object.class});
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(name + ".class");
            System.out.println((new File("hello")).getAbsolutePath());
            out.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
