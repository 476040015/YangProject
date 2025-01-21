package com.example.work.common;

public enum  ExceptionEnum {

    SYSTEM_ERROR("SYSTEM_ERROR","系统异常"),
    USER_LOGIN("00001","登陆失败"),
    USER_REGISTER0("00002","请填写正确账号信息"),
    STAFF_UPDATE("00003","更新员工信息失败，请检查填写内容"),
    ADD_STAFF("00004","该用户已存在"),
    ADD_STAFF2("00005","该部门已存在主任")

    ;


    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    ExceptionEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static ExceptionEnum getByCode(String errorCode){
        for (ExceptionEnum value : ExceptionEnum.values()) {
            if(value.getErrorCode().equals(errorCode)){
                return value;
            }
        }
        return null;
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
