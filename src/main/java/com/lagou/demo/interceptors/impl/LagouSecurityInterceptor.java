package com.lagou.demo.interceptors.impl;

import com.lagou.edu.mvcframework.annotations.LagouSecurity;
import com.lagou.edu.mvcframework.annotations.LagouService;
import com.lagou.edu.mvcframework.exceptions.SecurityException;
import com.lagou.demo.interceptors.HandlerInterceptor;
import com.lagou.edu.mvcframework.pojo.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fgm
 * @description 权限验证拦截器
 * @date 2020-03-01
 ***/
@LagouService
public class LagouSecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Handler handler) {
        if(!handler.getMethod().isAnnotationPresent(LagouSecurity.class)){
            return true;
        }
        Object requestUserName=request.getAttribute("username");
        LagouSecurity lagouSecurity=handler.getMethod().getAnnotation(LagouSecurity.class);
        String accessUserName=lagouSecurity.value();
        if(null==requestUserName||!accessUserName.equals(requestUserName)){
            throw new SecurityException(SecurityException.ERROR_CODE_FORBIDDEN,"暂无访问权限!");
        }
        return true;
    }

    @Override
    public boolean postHandle(HttpServletRequest request, HttpServletResponse response, Handler handler) {
        return false;
    }

    @Override
    public boolean afterCompletion(HttpServletRequest request, HttpServletResponse response, Handler handler) {
        return false;
    }
}
