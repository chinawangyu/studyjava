package com.test.error;

public interface CommonError {

    public Integer getErrorCode();

    public String getErrMsg();

    public CommonError setErrMsg(String errMsg);
}
