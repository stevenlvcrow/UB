package com.miyou.domain;

import lombok.Data;

import java.util.HashMap;

@Data
public class BusinessContext {

    private long serviceAcceptTime = System.currentTimeMillis();

    private BusinessRequest businessRequest;

    private String businessRequestStr;

    private BusinessResponse businessResponse;

    private String businessResponseStr;

    private HashMap<String, Object> contextMap = new HashMap<String, Object>();
}
