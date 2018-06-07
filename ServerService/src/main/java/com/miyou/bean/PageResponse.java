package com.miyou.bean;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse {

   public List list;

   public Integer total;
}
