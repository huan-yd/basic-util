package com.huan.enums;

/**
 * @Author YueDong Huan
 * @Date 2021/5/20
 * @Email huanyued@163.com
 */
public enum MsgCommonEnum {

    E0000("服务器内部异常:{}"),
    E0001("参数校验失败:{}");

    String value;

    MsgCommonEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
