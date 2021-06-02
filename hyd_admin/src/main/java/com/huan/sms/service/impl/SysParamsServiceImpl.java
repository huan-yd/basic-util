package com.huan.sms.service.impl;

import com.alibaba.fastjson.JSON;
import com.huan.sms.service.SysParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 参数管理
 */
@Service
public class SysParamsServiceImpl implements SysParamsService {

    /**
     * 根据paramCode 即sms_config_key
     * 获取value
     * {"platform":4,"aliyunAccessKeyId":"1","aliyunAccessKeySecret":"1","aliyunSignName":"1","aliyunTemplateCode":"1","qcloudAppId":23,"qcloudAppKey":"2","qcloudSignName":"2","qcloudTemplateId":"2","xaoSmsUid":"81317","xaoSmsCompanyCode":"hnsz","xaoSmsPassword":"8HSW9rR#","xaoSmsTemplate":"尊敬的用户，您正在进行对长沙市 工会云的操作,验证码为{0},请不要将验证码告诉任何人哦。","chinamobileUrl":"http://112.35.1.155:1992/sms/norsubmit","chinamobileApId":"qzwsgh","chinamobileEcName":"泉州市总工会","chinamobileSecretKey":"1qaz@WSX","chinamobileSign":"5dQhd4k3t"}
     * 再将value转为对象
     */



    //@Autowired
    //private SysParamsRedis sysParamsRedis;


    public String getValue(String paramCode) {
        String paramValue = null;//sysParamsRedis.get(paramCode);
        if (paramValue == null) {
            //paramValue = baseDao.getValueByCode(paramCode);
            //sysParamsRedis.set(paramCode, paramValue);
        }
        return paramValue;
    }

    @Override
    public <T> T getValueObject(String paramCode, Class<T> clazz) {
        String paramValue = getValue(paramCode);

        /*if (StringUtils.isNotBlank(paramValue)) {
            return JSON.parseObject(paramValue, clazz);
        }*/
        if (false) {
            return JSON.parseObject(paramValue, clazz);
        }


        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            //throw new SysException(ErrorCode.PARAMS_GET_ERROR);
            throw new ExceptionInInitializerError();
        }
    }

}
