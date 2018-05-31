package com.miyou.config;


import com.miyou.constant.BusinessConstant;
import com.miyou.domain.BusinessResponse;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.ConnectException;

/**
　* @Description: contoller所有异常都抛向这里
　* @author lizhijie
　* @date 2018/2/7 14:04
　*/
@Slf4j
@ControllerAdvice
@ResponseStatus(value = HttpStatus.OK)
@ResponseBody
public class GlobalException {


    @ExceptionHandler(ZuulException.class)
    public Object exceptionZuulException(Exception e) {
        log.error("{}" , e);
        return timeOutRefund();
    }

    @ExceptionHandler(ConnectException.class)
    public Object exceptionConnectExceptionException(Exception e) {
        log.error("{}" , e);
        return timeOutRefund();
    }

    @ExceptionHandler(IllegalStateException.class)
    public Object illegalStateExceptionException(Exception e) {
        log.error("{}" , e);
        BusinessResponse errorRes = new BusinessResponse();
        errorRes.setErrCode(BusinessConstant.ERR_CODE.FATAL);
        errorRes.setErrInfo("系统内部错误");
        return errorRes;
    }

    private BusinessResponse timeOutRefund(){
        BusinessResponse errorRes = new BusinessResponse();
        errorRes.setErrCode(BusinessConstant.ERR_CODE.FATAL);
        errorRes.setErrInfo("系统连接超时,请稍候再试...");
        return errorRes;
    }

}
