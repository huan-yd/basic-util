package com.huan.postconstructdemo;

import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author YueDong Huan
 * @Date 2021/9/24
 * @Email huanyued@163.com
 * @Version 1.0
 */
@Component
public class Family {
    @Resource
    Chicken chicken;

    public static List<String> names;

    @PostConstruct
    public void init(){
        names.add(chicken.getName());
        System.out.println("已添加肯德基全家桶豪华套餐");
    }
    public Family() {
        names = new LinkedList<>();
    }
}
