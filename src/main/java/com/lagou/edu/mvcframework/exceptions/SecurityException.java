package com.lagou.edu.mvcframework.exceptions;

/**
 * @author fgm
 * @description  权限异常
 * @date 2020-03-01
 ***/
public class SecurityException extends RuntimeException{

    //参数异常
    public static final String ERROR_CODE_PARAM="400";
    //权限异常
    public static final String ERROR_CODE_FORBIDDEN="403";
    //服务异常
    public static final String ERROR_CODE_SERVER="500";

    private String errorCode;
    private String errorMsg;

    public SecurityException(String errorMsg){
        super(errorMsg);
        this.errorCode = ERROR_CODE_SERVER;
        this.errorCode = errorMsg;
    }

    public SecurityException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
