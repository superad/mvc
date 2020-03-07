package com.lagou.demo.interceptors;

import com.lagou.edu.mvcframework.pojo.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fgm
 * @description  handler拦截器
 * @date 2020-03-01
 ***/
public interface HandlerInterceptor {
    /**
     * 请求前置拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     */
    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Handler handler);

    /**
     * 请求后置拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     */
    boolean postHandle(HttpServletRequest request, HttpServletResponse response, Handler handler);

    /**
     * 请求完成拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     */
    boolean afterCompletion(HttpServletRequest request, HttpServletResponse response, Handler handler);


}
