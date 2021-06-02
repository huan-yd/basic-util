package com.huan.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Author YueDong Huan
 * @Date 2021/5/20
 * @Email huanyued@163.com
 */
public class MemberPoJo {

    @NotNull(message = "请填id")
    private String id;

    @NotEmpty(message = "请填写姓名")
    @Pattern(regexp = "^[\u4e00-\u9fa5],{0,}$", message = "姓名不符合格式")
    private String name;

}
