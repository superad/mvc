package com.lagou.edu.mvcframework.pojo;

import com.lagou.demo.interceptors.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author fgm
 * @description  handler执行链
 * @date 2020-03-01
 ***/
public class HandlerExecutionChain {

    private Handler handler;

    private List<HandlerInterceptor> handlerInterceptorList;

    public HandlerExecutionChain(Handler handler,
                                 List<HandlerInterceptor> handlerInterceptorList) {
        this.handler = handler;
        this.handlerInterceptorList = handlerInterceptorList;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public List<HandlerInterceptor> getHandlerInterceptorList() {
        return handlerInterceptorList;
    }

    public void setHandlerInterceptorList(List<HandlerInterceptor> handlerInterceptorList) {
        this.handlerInterceptorList = handlerInterceptorList;
    }

    /**
     * 执行拦截器
     * @param req
     * @param resp
     * @return
     */
    public boolean applyPreHandle(HttpServletRequest req, HttpServletResponse resp) {
        List<HandlerInterceptor> interceptorList=this.handlerInterceptorList;
        if(null==interceptorList||interceptorList.size()==0){
            return true;
        }
        for(HandlerInterceptor interceptor:interceptorList){
            if(!interceptor.preHandle(req,resp,this.handler)){
                return false;
            }
        }
        return true;
    }
}
