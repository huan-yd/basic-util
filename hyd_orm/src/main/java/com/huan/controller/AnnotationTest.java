package com.huan.controller;

import com.huan.annotation.AnnotationParser;
import com.huan.entity.User;

/**
 * @Author YueDong Huan
 * @Date 2021/6/2
 * @Email huanyued@163.com
 */
public class AnnotationTest {

    public static void main(String[] args) {
        User testDto = new User("123");
        String sql = AnnotationParser.assembleSqlFromObj(testDto);
        System.out.println(sql);

    }
}
