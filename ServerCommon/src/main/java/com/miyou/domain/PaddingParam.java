package com.miyou.domain;


import lombok.Data;

@Data
public class PaddingParam extends BusinessRequest{

    public Object tableBean;

    public String sort;

    public Integer page;

    public Integer size;
}
