package com.huan.sms.service;

import com.huan.config.SmsConfig;

import java.util.LinkedHashMap;

/**
 * 腾讯云短信服务
 */
public class QcloudSmsService extends AbstractSmsService {
    public QcloudSmsService(SmsConfig config) {
        this.config = config;
    }

    @Override
    public void sendSms(String mobile, LinkedHashMap<String, String> params) {
        this.sendSms(mobile, params, config.getQcloudSignName(), config.getQcloudTemplateId());
    }

    @Override
    public void sendText(String mobile, String text) {
        //todo:待实现
    }

    @Override
    public void sendSms(String mobile, LinkedHashMap<String, String> params, String signName, String template) {

    }

    /*@Override
    public void sendSms(String mobile, LinkedHashMap<String, String> params, String signName, String template) {
        SmsSingleSender sender = new SmsSingleSender(config.getQcloudAppId(), config.getQcloudAppKey());

        //短信参数
        ArrayList<String> paramsList = new ArrayList<>();
        if (MapUtil.isNotEmpty(params)) {
            for (String value : params.values()) {
                paramsList.add(value);
            }
        }
        SmsSingleSenderResult result;
        try {
            result = sender.sendWithParam("86", mobile, Integer.parseInt(template), paramsList, signName, null, null);
        } catch (Exception e) {
            throw new SysException(ErrorCode.SEND_SMS_ERROR, e, "");
        }

        int status = Constant.SUCCESS;
        if (result.result != 0) {
            status = Constant.FAIL;
        }

        //保存短信记录
        SysSmsService sysSmsService = SpringContextUtils.getBean(SysSmsService.class);
        sysSmsService.save(Constant.SmsService.QCLOUD.getValue(), mobile, params, status);

        if (status == Constant.FAIL) {
            throw new SysException(ErrorCode.SEND_SMS_ERROR, result.errMsg);
        }
    }*/
}
