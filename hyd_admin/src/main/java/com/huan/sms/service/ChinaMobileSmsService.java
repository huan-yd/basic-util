package com.huan.sms.service;

import com.alibaba.fastjson.JSONObject;
import com.huan.config.SmsConfig;
import com.huan.constants.Constant;
import com.huan.dto.SendMesReq;
import com.huan.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.LinkedHashMap;

@Slf4j
public class ChinaMobileSmsService extends AbstractSmsService {

    private String mobile;
    private LinkedHashMap<String, String> params;

    public ChinaMobileSmsService(SmsConfig config) {
        this.config = config;
    }


    @Override
    public void sendSms(String mobile, LinkedHashMap<String, String> params) {
        String msg = "尊敬的用户，您正在进行对泉州市网上工作平台的操作，验证码为"+params.get("code")+",请不要将验证码告诉任何人哦。";
        SendMesReq sendMesReq = new SendMesReq();
        sendMesReq.setAddSerial("");
        sendMesReq.setApId(config.getChinamobileApId());
        sendMesReq.setEcName(config.getChinamobileEcName());
        sendMesReq.setSecretKey(config.getChinamobileSecretKey());
        sendMesReq.setMobiles(mobile);
        sendMesReq.setSign(config.getChinamobileSign());
        sendMesReq.setContent(msg);
        sendMesReq.setTimeOpreation(90L);
        String resultStr=null;
        try {
            resultStr = "";//postWithJson(GetSmsParam(sendMesReq),config.getChinamobileUrl());
        //} catch (IOException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(resultStr);
        log.info("The result is "+ resultStr);
        int status = Constant.FAIL;
        if(jsonObject.get("success")!=null && jsonObject.get("success").toString().equals("true")){
            status = Constant.SUCCESS;
        }
        SysSmsService sysSmsService = SpringContextUtils.getBean(SysSmsService.class);
        sysSmsService.save(Constant.SmsService.CHINAMOBILE.getValue(), mobile, params, status);
    }

    /*@Override
    public void sendText(String mobile, String text) {
        SendMesReq sendMesReq = new SendMesReq();
        sendMesReq.setAddSerial("");
        sendMesReq.setApId(config.getChinamobileApId());
        sendMesReq.setEcName(config.getChinamobileEcName());
        sendMesReq.setSecretKey(config.getChinamobileSecretKey());
        Set<String> mobileSet = Arrays.asList(mobile.split(",")).stream().collect(Collectors.toSet());
        mobile  = Joiner.on(",").join(mobileSet);
        sendMesReq.setMobiles(mobile);
        sendMesReq.setSign(config.getChinamobileSign());
        sendMesReq.setTimeOpreation(90L);
        sendMesReq.setContent(text);
        String resultStr=null;
        try {
            resultStr = postWithJson(GetSmsParam(sendMesReq),config.getChinamobileUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(resultStr);
        log.info("The result is "+ resultStr);
        int status = Constant.FAIL;
        if(jsonObject.get("success")!=null && jsonObject.get("success").toString().equals("true")){
            status = Constant.SUCCESS;
        }
        SysSmsService sysSmsService = SpringContextUtils.getBean(SysSmsService.class);
        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        params.put("content",text);
        sysSmsService.save(Constant.SmsService.CHINAMOBILE.getValue(), mobile, params,status );
    }

    *//**
     * 发送模板短信，(没有账号，登录mas平台，暂时写死为验证码)
     * @param mobile   手机号
     * @param params   参数
     * @param signName 短信签名
     * @param template 短信模板
     *//*
    @Override
    public void sendSms(String mobile, LinkedHashMap<String, String> params, String signName, String template) {
    }

    private static String GetSmsParam(SendMesReq sendMesReq){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sendMesReq.getEcName());
        stringBuffer.append(sendMesReq.getApId());
        stringBuffer.append(sendMesReq.getSecretKey());
        stringBuffer.append(sendMesReq.getMobiles());
        stringBuffer.append(sendMesReq.getContent());
        stringBuffer.append(sendMesReq.getSign());
        stringBuffer.append(sendMesReq.getAddSerial());
        log.info("The paramStr is "+stringBuffer.toString());
        log.info("After Md5Crypt the MAC is"+ MD5Util.encrypt(stringBuffer.toString()));
        sendMesReq.setMac(MD5Util.encrypt(stringBuffer.toString()));
        log.info("The param is "+ JSONObject.toJSONString(sendMesReq));
        return Base64Util.encode(JSONObject.toJSONString(sendMesReq).getBytes());
    }*/

    /**
     * 6位随机生成验证码
     */
    public static String randomCode() {
        //验证码
        StringBuilder vcode = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            vcode.append((int) (Math.random() * 9));
        }
        return vcode.toString();
    }

    @Override
    public void sendText(String mobile, String text) {

    }

    @Override
    public void sendSms(String mobile, LinkedHashMap<String, String> params, String signName, String template) {

    }
}
