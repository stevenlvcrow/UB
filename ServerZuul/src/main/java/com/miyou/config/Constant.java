package com.miyou.config;

import org.springframework.http.HttpHeaders;

public class Constant {

    public static HttpHeaders JSON_HEADER;

    public static String SERVICEUTL = "http://service/www/api/";

    Constant() {
        JSON_HEADER.add("Content-Type", "application/json");
    }
}
