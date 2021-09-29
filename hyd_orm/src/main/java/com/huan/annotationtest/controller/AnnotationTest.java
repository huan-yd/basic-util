package com.huan.annotationtest.controller;

import com.huan.annotationtest.AnnotationParser;
import com.huan.annotationtest.entity.User;

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
