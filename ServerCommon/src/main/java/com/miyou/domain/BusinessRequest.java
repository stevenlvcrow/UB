package com.miyou.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.servlet.http.HttpSession;

/**
* @Author: lizhijie
* @Description: 请求体
* @Date: Created in 16:44 2018/5/25
*/
@Data
public class BusinessRequest {

    private HttpSession session;

//    @NotEmpty(message="签名不能为空")
    private String token;

    private String requestStr;

//    @NotEmpty(message="私钥不能为空")
    private String privateKey;
}
