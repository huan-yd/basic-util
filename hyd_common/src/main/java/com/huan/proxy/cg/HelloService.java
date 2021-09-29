package com.huan.proxy.cg;

/**
 * @Author YueDong Huan
 * @Date 2021/9/22
 * @Email huanyued@163.com
 * @Version 1.0
 */
public class HelloService {

    public HelloService() {
        System.out.println("HelloService构造");
    }

    /**
     * 该方法不能被子类覆盖,Cglib是无法代理final修饰的方法的
     */
    final public String sayOthers(String name) {
        System.out.println("HelloService:sayOthers>>" + name);
        return null;
    }

    public void sayHello() {
        System.out.println("HelloService:sayHello");
    }

}
