package com.miyou.bean;

import com.miyou.domain.BusinessRequest;
import com.miyou.domain.PaddingParam;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PageRequest extends BusinessRequest {

    @NotNull(message = "请求对象不能为空")
    PaddingParam paddingParam;
}
