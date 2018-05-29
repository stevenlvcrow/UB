package com.miyou.controller.web;


import com.miyou.config.Constant;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api-b")
public class WebController {

    @Autowired
    public RestTemplate restTemplate;

    @ResponseBody
    @ApiOperation(value="测试接口", notes="测试通讯是否正常的接口")
    @ApiImplicitParam(name = "postParameters", value = "TestVo", required = true, dataType = "TestVo")
    @PostMapping("/test")
    public Object home(@RequestBody String postParameters) {
        return restTemplate.postForObject("http://service/www/api/test",new HttpEntity(postParameters, Constant.JSONHEADER),String.class);
    }
}
