package com.miyou.config;

import org.springframework.http.HttpHeaders;

public class Constant {

    public static HttpHeaders JSONHEADER;

    static {
        JSONHEADER.add("Content-Type", "application/json");
    }
}
