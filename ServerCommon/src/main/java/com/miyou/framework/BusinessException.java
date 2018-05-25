package com.miyou.framework;

import lombok.Getter;

public class BusinessException extends Exception {
    @Getter
    private String errCode;
    @Getter
    private String errInfo;
    public BusinessException(String errCode) {
        super(errCode);
        this.errCode = errCode;
    }
    public BusinessException(String errCode, Throwable e) {
        super(errCode, e);
        this.errCode = errCode;
    }
    public BusinessException(String errCode, String errInfo) {
        super(errCode + ',' + errInfo);
        this.errCode = errCode;
        this.errInfo = errInfo;
    }
    public BusinessException(String errCode, String errInfo, Throwable e) {
        super(errCode + ',' + errInfo, e);
        this.errCode = errCode;
        this.errInfo = errInfo;
    }
}
