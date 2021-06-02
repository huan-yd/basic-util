package com.huan.sms.controller;

import com.huan.sms.service.SysSmsService;
import com.huan.utils.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @Author YueDong Huan
 * @Date 2021/6/2
 * @Email huanyued@163.com
 */
public class SmsController {

    @Autowired
    private SysSmsService sysSmsService;


    @PostMapping("/sendText")
    /*@ApiOperation("发送短信")
    @LogOperation("发送短信")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "content", value = "内容", paramType = "query", required = true, dataType = "String")
    })*/
    public void sendSms(@RequestBody Map<String, Object> params) {
        if (ToolUtil.isEmpty(params)) {
            //return new Result().error("参数不能为空");
        }
        if (ToolUtil.isEmpty(params.get("mobile"))) {
            //return new Result().error("手机号不能为空");
        }
        String mobile = params.get("mobile").toString();
        if (ToolUtil.isEmpty(params.get("content"))) {
            //return new Result().error("短信内容不能为空");
        }
        String content = params.get("content").toString();
        sysSmsService.sendText(mobile, content);
        //return new Result();
    }
}
