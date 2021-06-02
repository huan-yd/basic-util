package com.huan.sms.service.impl;

import com.huan.config.SmsFactory;
import com.huan.sms.service.AbstractSmsService;
import com.huan.sms.service.SysSmsService;

import java.util.LinkedHashMap;

/**
 * @Author YueDong Huan
 * @Date 2021/6/2
 * @Email huanyued@163.com
 */
public class SysSmsServiceImpl implements SysSmsService {

    @Override
    public void send(String mobile, String params) {

    }

    @Override
    public void sendText(String mobile, String text) {
        //短信服务
        AbstractSmsService service = SmsFactory.build();

        /*if (service == null) {
            throw new SysException(ErrorCode.SMS_CONFIG);
        }*/

        //发送短信
        service.sendText(mobile, text);
    }

    @Override
    public void save(Integer platform, String mobile, LinkedHashMap<String, String> params, Integer status) {

    }

}
