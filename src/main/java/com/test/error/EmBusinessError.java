package com.test.error;

public enum EmBusinessError implements CommonError {
    UNKNOWN_ERRORS(10001, "系统错误"),
    PARAMS_ERRORS(20000, "参数错误"),
    DATA_NOT_EXIST(20001, "数据不存在");


    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;

    private String errMsg;

    @Override
    public Integer getErrorCode() {
        return errCode;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
