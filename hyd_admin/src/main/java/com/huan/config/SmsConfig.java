package com.huan.config;


import com.huan.vaildator.group.AliyunGroup;
import com.huan.vaildator.group.ChinaMobileGroup;
import com.huan.vaildator.group.QcloudGroup;
import com.huan.vaildator.group.XIAOGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 短信配置信息
 */
@Data
public class SmsConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    @Range(min = 1, max = 4, message = "{sms.platform.range}")
    private Integer platform;

    //@ApiModelProperty(value = "阿里云AccessKeyId")
    @NotBlank(message = "{aliyun.accesskeyid.require}", groups = AliyunGroup.class)
    private String aliyunAccessKeyId;

    //@ApiModelProperty(value = "阿里云AccessKeySecret")
    @NotBlank(message = "{aliyun.accesskeysecret.require}", groups = AliyunGroup.class)
    private String aliyunAccessKeySecret;

    //@ApiModelProperty(value = "阿里云短信签名")
    @NotBlank(message = "{aliyun.signname.require}", groups = AliyunGroup.class)
    private String aliyunSignName;

    //@ApiModelProperty(value = "阿里云短信模板")
    @NotBlank(message = "{aliyun.templatecode.require}", groups = AliyunGroup.class)
    private String aliyunTemplateCode;

    //@ApiModelProperty(value = "腾讯云AppId")
    @NotNull(message = "{qcloud.appid.require}", groups = QcloudGroup.class)
    private Integer qcloudAppId;

    //@ApiModelProperty(value = "腾讯云AppKey")
    @NotBlank(message = "{qcloud.appkey.require}", groups = QcloudGroup.class)
    private String qcloudAppKey;

    //@ApiModelProperty(value = "腾讯云短信签名")
    @NotBlank(message = "{qcloud.signname.require}", groups = QcloudGroup.class)
    private String qcloudSignName;

    //@ApiModelProperty(value = "腾讯云短信模板ID")
    @NotBlank(message = "{qcloud.templateid.require}", groups = QcloudGroup.class)
    private String qcloudTemplateId;

    //@ApiModelProperty(value = "希奥短信用户ID")
    @NotBlank(message = "{xiaoSms.xaoSmsUid.require}", groups = XIAOGroup.class)
    private String xaoSmsUid;

    //@ApiModelProperty(value = "希奥短信企业代码")
    @NotBlank(message = "{xiaoSms.companyCode.require}", groups = XIAOGroup.class)
    private String xaoSmsCompanyCode;

    //@ApiModelProperty(value = "希奥短息密码")
    @NotBlank(message = "{xiaoSms.password.require}", groups = XIAOGroup.class)
    private String xaoSmsPassword;

    //@ApiModelProperty(value = "希奥验证码模板")
    @NotBlank(message = "{xiaoSms.template.require}", groups = XIAOGroup.class)
    private String xaoSmsTemplate;//尊敬的用户，您正在华虹工会平台进行操作,验证码为{0},请妥善保管。

    //@ApiModelProperty(value = "中国移动MAS平台URL")
    @NotNull(message = "{chinamobile.url.require}", groups = ChinaMobileGroup.class)
    private String chinamobileUrl;

    //@ApiModelProperty(value = "中国移动MAS平台ApId")
    @NotNull(message = "{chinamobile.apid.require}", groups = ChinaMobileGroup.class)
    private String chinamobileApId;

    //@ApiModelProperty(value = "中国移动MAS平台EcName")
    @NotNull(message = "{chinamobile.ecname.require}", groups = ChinaMobileGroup.class)
    private String chinamobileEcName;

    //@ApiModelProperty(value = "中国移动MAS平台SecretKey")
    @NotBlank(message = "{chinamobile.secretkey.require}", groups = ChinaMobileGroup.class)
    private String chinamobileSecretKey;

    //@ApiModelProperty(value = "中国移动MAS平台Sign")
    @NotBlank(message = "{chinamobile.sign.require}", groups = ChinaMobileGroup.class)
    private String chinamobileSign;

}