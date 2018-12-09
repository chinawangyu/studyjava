package com.test.controller;

import com.test.error.BusinessException;
import com.test.error.EmBusinessError;
import com.test.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    /**
     * 自动执行所有未被捕获的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex) {

        Map<String, Object> responseData = new HashMap<String, Object>();

        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errCode", businessException.getErrorCode());
            responseData.put("errMsg", businessException.getErrMsg());
            return CommonReturnType.create(responseData, "fail");
        } else {
            responseData.put("errCode", EmBusinessError.UNKNOWN_ERRORS.getErrorCode());
            responseData.put("errMsg", EmBusinessError.UNKNOWN_ERRORS.getErrMsg());
        }

        return CommonReturnType.create(responseData, "fail");
    }

}
