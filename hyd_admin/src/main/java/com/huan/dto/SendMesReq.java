package com.huan.dto;

import lombok.Data;


@Data
public class SendMesReq {

    /*
      ecName	String	企业名称。
      apId	String	接口账号用户名。
      mobiles	String	收信手机号码。英文逗号分隔，每批次限5000个号码，
               例：“13800138000,13800138001,13800138002”。
      content	String	短信内容。
      sign	String	签名编码。在云MAS平台『管理』→『接口管理』→『短信接入用户管理』获取。
      addSerial	String	扩展码。依据申请开户的服务代码匹配类型而定，如为精确匹配，
               此项填写空字符串（""）；如为模糊匹配，此项可填写空字符串或自定义的扩展码，注：服务代码加扩展码总长度不能超过20位。
      mac	String	参数校验序列，生成方法：将ecName、apId、secretKey、mobiles、
               content、sign、addSerial按序拼接（无间隔符），通过MD5（32位小写）计算得出值。
      */


    /**
     * 企业名称:
     */
    private String ecName;

    /**
     * 接口账号用户名。
     */
    private String apId;

    /**
     * secretKey 用户名密码
     */
    private String secretKey;

    /**
     * 收信手机号码。英文逗号分隔，每批次限5000个号码，
     * 例：“13800138000,13800138001,13800138002”。
     */
    private String mobiles;


    /**
     * 短信内容
     */
    private String content;

    /**
     * 签名编码
     */
    private String sign;

    /**
     * 宽展码
     */
    private String addSerial;

    /**
     * mac  参数校验序列
     */
    private String mac;

    /**
     * 页面给的过期时间  1分钟  注册    5 分钟 忘记密码
     */
    private Long timeOpreation;


}

