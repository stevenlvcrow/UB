package com.miyou.framework;

import lombok.Data;

@Data
public class BusinessResponse {

    private String errCode = BusinessConstant.ERR_CODE.NORMAL;
    private String errInfo = BusinessConstant.ERR_INFO.NORMAL;
}