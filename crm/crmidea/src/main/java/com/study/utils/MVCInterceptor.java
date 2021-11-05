package com.study.utils;



import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截器
 */

public class MVCInterceptor implements HandlerInterceptor {
    //请求即将进入Controller的时候，对HttpServletResponse对象进行配置
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Credentials","true");//允许前端在请求头中加载和cookie、session相关的信息
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        response.setHeader("Access-Control-Allow-Headers","Authorization,Origin, X-Requested-With, Content-Type, Accept,Access-Token");
        return true;
    }
}
