package com.miyou.domain;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PaddingParam{

    public Object tableBean;

    @NotNull(message = "排序字段不能为空")
    public String sort;

    @NotNull(message = "页数不能为空")
    public Integer page;

    @NotNull(message = "每页显示条数")
    public Integer size;
}
