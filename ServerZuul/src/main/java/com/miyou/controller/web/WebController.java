package com.miyou.controller.web;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api-b")
public class WebController {

    @Autowired
    public RestTemplate restTemplate;

    @ResponseBody
    @ApiOperation(value="测试接口", notes="测试通讯是否正常的接口")
    @ApiImplicitParam(name = "postParameters", value = "没有参数", required = false, dataType = "MultiValueMap<String, Object>")
    @PostMapping("/test")
    public Object home(@RequestBody String postParameters) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
            return restTemplate.postForObject("http://service/www/api/test",new HttpEntity(postParameters, headers),String.class);
    }
}
