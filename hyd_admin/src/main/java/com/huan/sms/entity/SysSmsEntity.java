package com.huan.sms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 短信
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysSmsEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 平台类型
     */
    private Integer platform;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 参数1
     */
    private String params1;
    /**
     * 参数2
     */
    private String params2;
    /**
     * 参数3
     */
    private String params3;
    /**
     * 参数4
     */
    private String params4;
    /**
     * 发送状态  0：失败   1：成功
     */
    private Integer status;

}