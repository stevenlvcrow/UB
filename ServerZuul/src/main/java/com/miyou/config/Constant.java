package com.miyou.config;

import org.springframework.http.HttpHeaders;

public class Constant {

    public static HttpHeaders JSONHEADER;

    public static String SERVICEUTL = "http://service/www/api/";

    Constant() {
        JSONHEADER.add("Content-Type", "application/json");
    }
}
