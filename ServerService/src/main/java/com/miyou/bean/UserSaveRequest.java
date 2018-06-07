package com.miyou.bean;

import com.miyou.domain.BusinessRequest;
import com.miyou.tableVo.UbUser;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class UserSaveRequest extends BusinessRequest {


    @NotNull(message = "请求对象不能为空")
    @Valid
    UbUser ubUser;
}
