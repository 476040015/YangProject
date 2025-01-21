package com.example.work.common;

/**
 * https://blog.csdn.net/m0_46624528/article/details/125058871
 * aop https://blog.csdn.net/weixin_43533825/article/details/108606356
 * Created by mulang on 2019/1/15.
 */
public class HandleException extends RuntimeException {
    /**
     * 错误吗
     */
    private String errorCode;


    /**
     * 构造方法
     * @param message
     */
    public HandleException(String message){
        super(message);
    }

    /**
     * 构造函数
     *
     * @param errorCode
     *            错误码
     * @param message
     *            错误信息
     */
    public HandleException(String errorCode, String message) {
        this(errorCode, message, null);
    }


    /**
     * 构造函数
     *
     * @param errorCode
     *            错误码
     * @param cause
     *            错误原因
     */
    public HandleException(String errorCode, Throwable cause) {
        this(errorCode, "errorCode: " + errorCode, cause);
    }

    /**
     * 构造函数
     *
     */
    public HandleException(ExceptionEnum exceptionEnum) {
        this(exceptionEnum.getErrorCode(), exceptionEnum.getErrorMsg());
    }


    /**
     * 构造函数
     *
     * @param errorCode
     *            错误码
     * @param message
     *            错误信息
     * @param cause
     *            错误原因
     */
    public HandleException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *            the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
