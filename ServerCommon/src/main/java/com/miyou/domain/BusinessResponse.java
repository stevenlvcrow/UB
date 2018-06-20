package com.miyou.domain;

import com.miyou.constant.BusinessConstant;
import lombok.Data;

@Data
public class BusinessResponse {

    private String errCode = BusinessConstant.ERR_CODE.NORMAL;
    private String errInfo = BusinessConstant.ERR_INFO.NORMAL;

    private Object responseData;

    public BusinessResponse(){}

    public BusinessResponse(Object responseData){
        this.responseData=responseData;
    }

    public boolean isFaild(){
        return !this.errCode.equals(BusinessConstant.ERR_CODE.NORMAL);
    }
}
