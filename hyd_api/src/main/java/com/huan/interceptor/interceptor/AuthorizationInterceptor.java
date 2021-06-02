package com.huan.interceptor.interceptor;

import com.huan.interceptor.annotation.Login;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @Author YueDong Huan
 * @Date 2021/5/26
 * @Email huanyued@163.com
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    private static final String[] arr = {"/wx/userInfo"};
    protected static final List<String> exclusions = Arrays.asList(arr);
    //以下是微信授权登录的步骤，如果要回复之前的，去掉之前的注释就可以⤴

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        System.out.println("此处为拦截器！");
        //校验是否拦截
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        if (exclusions.stream().anyMatch(url -> antPathMatcher.match(url, requestURI))) {
            return true;
        }

        String method = request.getMethod();

        if ("OPTIONS".equalsIgnoreCase(method)) {
            return true;
        }

        Login annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        } else {
            return true;
        }
        //判读当前方法是否添加了@Login注解
        if (annotation != null) {
            String token = request.getHeader("token");
            //先判断token是否存在
            /*if (ToolUtil.isEmpty(token)) {
                if (HttpBasic.isWechat()) {
                    throw new SysException(ErrorCode.WE_CHAT_VALID, PropKit.get("gate") + "/wx/authorize");
                } else {
                    throw new SysException(ErrorCode.TOKEN_INVALID);
                }
            }
            //无论如何都要求进行微信授权
            AppUserInfoDTO appUserInfoDTO = oauth2(token);
            if (HttpBasic.isWechat()) {
                if (!StringUtil.isBlank(appUserInfoDTO.getOpenId())) {
                    request.setAttribute(OPEN_ID, appUserInfoDTO.getOpenId());
                }
            }*/

        }
        return true;
    }

}
