package com.huan.config;


import com.huan.constants.Constant;
import com.huan.sms.service.*;
import com.huan.sms.service.AbstractSmsService;
import com.huan.utils.SpringContextUtils;

/**
 * 短信Factory
 */
public class SmsFactory {
    private static SysParamsService sysParamsService;

    static {
        //核心————SysParamsService运用了继承构建了sysParamsService对象，防治被篡改信息
        SmsFactory.sysParamsService = SpringContextUtils.getBean(SysParamsService.class);
    }

    public static AbstractSmsService build() {
        //获取短信配置信息
        SmsConfig config = sysParamsService.getValueObject(Constant.SMS_CONFIG_KEY, SmsConfig.class);

        if (config.getPlatform() == Constant.SmsService.ALIYUN.getValue()) {
            return new AliyunSmsService(config);
        } else if (config.getPlatform() == Constant.SmsService.QCLOUD.getValue()) {
            return new QcloudSmsService(config);
        } else if(config.getPlatform() == Constant.SmsService.XIAO.getValue()){
            return new XaoSmsService(config);
        } else if(config.getPlatform() == Constant.SmsService.CHINAMOBILE.getValue()){
            return new ChinaMobileSmsService(config);
        }
        return null;
    }
}
