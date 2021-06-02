package com.huan.sms.service;

import com.huan.config.SmsConfig;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;

public class XaoSmsService extends AbstractSmsService {
    public XaoSmsService(SmsConfig config) {
        this.config = config;
        /*this.SMS_UID = config.getXaoSmsUid();
        this.SMS_COMPANY_CDOE = config.getXaoSmsCompanyCode();
        this.SMS_PASSWORD = config.getXaoSmsPassword();
        this.AUTH_CODE_TEMPLATE = config.getXaoSmsTemplate();*/

    }

    @Override
    public void sendSms(String mobile, LinkedHashMap<String, String> params) {

    }

    @Override
    public void sendText(String mobile, String text) {

    }

    @Override
    public void sendSms(String mobile, LinkedHashMap<String, String> params, String signName, String template) {

    }


    /*@Override
    public void sendSms(String mobile, LinkedHashMap<String, String> params) {
        List<String> list  =new ArrayList();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            list.add(next.getValue());
        }
        String message = MessageFormat.format(AUTH_CODE_TEMPLATE, list.toArray());
        SysSmsService sysSmsService = SpringContextUtils.getBean(SysSmsService.class);
        boolean flag = sendMobileMessage(mobile, message);
        int status = Constant.SUCCESS;
        if(!flag){
            status = Constant.FAIL;
        }
        sysSmsService.save(Constant.SmsService.XIAO.getValue(), mobile, params,status );
    }

    @Override
    public void sendText(String mobile, String text) {
        SysSmsService sysSmsService = SpringContextUtils.getBean(SysSmsService.class);
        boolean flag = sendMobileMessage(mobile, text);
        int status = Constant.SUCCESS;
        if(!flag){
            status = Constant.FAIL;
        }
        sysSmsService.save(Constant.SmsService.XIAO.getValue(), mobile, null,status );
    }

    @Override
    public void sendSms(String mobile, LinkedHashMap<String, String> params, String signName, String template) {

        List<String> list  =new ArrayList();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            list.add(next.getValue());
        }
        String message = MessageFormat.format(template, list.toArray());
        SysSmsService sysSmsService = SpringContextUtils.getBean(SysSmsService.class);
        boolean flag = sendMobileMessage(mobile, message);
        int status = Constant.SUCCESS;
        if(!flag){
            status = Constant.FAIL;
        }
        sysSmsService.save(Constant.SmsService.XIAO.getValue(), mobile, params,status );


    }


    private final static Logger logger = LoggerFactory.getLogger(XaoSmsService.class);

    private static  String AUTH_CODE_TEMPLATE;

    *//**
     * 发送地址
     *//*
    private static final String SEND_URL = "http://sms.10690221.com:9011/hy/";

    *//**
     * 用户ID
     *//*
    private static  String SMS_UID ;
    *//**
     * 企业代码
     *//*
    private static  String SMS_COMPANY_CDOE;
    *//**
     * 帐号密码
     *//*
    private static  String SMS_PASSWORD;

    *//**
     * 转译类型
     *//*
    private static final String ENCODE = "utf-8";

    *//**
     * 发送验证嘛
     *
     * @param mobile
     * @param code
     * @return
     *//*
    public static boolean sendAuthCode(String mobile, String code) {
        String message = MessageFormat.format(AUTH_CODE_TEMPLATE, code);
        return sendMobileMessage(mobile, message);
    }


    *//**
     * 发送手机短信
     *
     * @param mobile
     * @param message
     * @return
     *//*
    public static boolean sendSMS(String mobile, String message) {
        return sendMobileMessage(mobile, message);
    }

    *//**
     * 将字符串使用urlEncode
     *
     * @param msg
     * @return
     * @throws UnsupportedEncodingException
     *//*
    private static String encodeMessage(String msg) throws UnsupportedEncodingException {
        if (msg.indexOf("回复T退订") < 0) {
            if (msg.endsWith("。") || msg.endsWith(".")) {
                msg += "回复T退订";
            } else {
                msg += "。回复T退订";
            }
        }
        return URLEncoder.encode(msg, ENCODE);
    }

    *//**
     * 发送短信
     *
     * @param mobile  手机号
     * @param message 发送消息
     * @return
     *//*
    private static boolean sendMobileMessage(String mobile, String message) {
        logger.info("短信发送,手机号：" + mobile + ",内容:" + message);
        try {
            message = encodeMessage(message);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        Map<String, String> parameters = new HashMap<>();
        parameters.put("uid", SMS_UID);
        parameters.put("auth", MD5Util.encrypt(SMS_COMPANY_CDOE + SMS_PASSWORD));
        parameters.put("mobile", mobile);
        parameters.put("msg", message);
        parameters.put("expid", "0");
        parameters.put("encode", ENCODE);
        String result = HttpUtil.sendPost(SEND_URL, parameters);
        logger.info("短信发送回复：" + result);
        if (StringUtils.isEmpty(result)) {
            return false;
        }
        try {
            if ("0".equals(result.split(",")[0])) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        sendAuthCode("15901847435", "223451");
    }*/

}
