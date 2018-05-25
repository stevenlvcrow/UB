package com.miyou.bean;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class LoginInfo {

    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    private String pwd;

    private String loginResponse;
}
