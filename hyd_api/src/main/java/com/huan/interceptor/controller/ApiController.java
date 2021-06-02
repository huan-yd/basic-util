package com.huan.interceptor.controller;

import com.huan.interceptor.annotation.Login;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @Author YueDong Huan
 * @Date 2021/5/27
 * @Email huanyued@163.com
 */
@RequestMapping("/api")
@RestController
public class ApiController {

    /**
     * 查询资讯列表
     *
     * @return
     */
    @GetMapping(value = "/getArticleList")
    @ApiOperation("App首页资讯列表")
    @Login
    public void articleList(@ApiIgnore @RequestParam Map<String, Object> map) {
        System.out.println("");
    }

}
