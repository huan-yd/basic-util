package com.huan.annotationtest.entity;

import com.huan.annotationtest.annotation.Column;
import com.huan.annotationtest.annotation.Table;

import java.io.Serializable;

/**
 * @Author YueDong Huan
 * @Date 2021/6/2
 * @Email huanyued@163.com
 */
@Table(tableName = "user")
public class User implements Serializable {

    @Column(columnName = "id")
    private String id;

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
