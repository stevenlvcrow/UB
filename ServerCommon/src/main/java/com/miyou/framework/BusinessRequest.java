package com.miyou.framework;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.servlet.http.HttpSession;

/**
 * Created by zhuhongqing on 2018/5/8.
 */
@Data
public class BusinessRequest {

    private HttpSession session;

    @NotEmpty(message="签名不能为空")
    private String token;

    private String requestStr;

    @NotEmpty(message="私钥不能为空")
    private String privateKey;
}
