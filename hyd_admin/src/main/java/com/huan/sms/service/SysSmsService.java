package com.huan.sms.service;


import com.huan.dto.SysSmsDTO;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 短信
 */
public interface SysSmsService {

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param params 短信参数
     */
    void send(String mobile, String params);

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param text 内容
     */
    void sendText(String mobile, String text);

    /**
     * 保存短信发送记录
     *
     * @param platform 平台
     * @param mobile   手机号
     * @param params   短信参数
     * @param status   发送状态
     */
    void save(Integer platform, String mobile, LinkedHashMap<String, String> params, Integer status);
}

