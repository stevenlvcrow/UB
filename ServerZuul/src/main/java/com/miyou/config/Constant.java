package com.miyou.config;

import org.springframework.http.HttpHeaders;

public class Constant {

    public static HttpHeaders JSONhEADER;

    static {
        JSONhEADER.add("Content-Type", "application/json");
    }
}
