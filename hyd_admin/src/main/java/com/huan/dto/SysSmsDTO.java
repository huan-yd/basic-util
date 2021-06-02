package com.huan.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 短信
 */
@Data
public class SysSmsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer platform;

    private String mobile;

    private String params1;

    private String params2;

    private String params3;

    private String params4;

    private Integer status;

    private String createDate;

}
