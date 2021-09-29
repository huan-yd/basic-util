package com.huan.postconstructdemo;

/**
 * @Author YueDong Huan
 * @Date 2021/9/24
 * @Email huanyued@163.com
 * @Version 1.0
 */
public class Chicken {

    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chicken() {
    }

    public Chicken(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "name='" + name + '\'' +
                '}';
    }
}
