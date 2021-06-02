package com.huan.controller;

import com.huan.entity.MemberPoJo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author YueDong Huan
 * @Date 2021/5/20
 * @Email huanyued@163.com
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @PostMapping
    public void MemberList(@RequestBody @Validated MemberPoJo memberPoJo) {
        System.out.println("xxx");
    }


}
