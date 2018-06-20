package com.miyou.controller.web;


import com.miyou.config.Constant;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys")
public class SystemController extends WebController {



    @ResponseBody
    @ApiOperation(value="登录接口", notes="返回登录人信息")
    @ApiImplicitParam(name = "postParameters", value = "{userName:'', pwd:''}", required = true, dataType = "LoginRequest")
    @PostMapping("/login")
    public Object home(@RequestBody String postParameters) {
        return restTemplate.postForObject(Constant.SERVICEUTL+"/login",new HttpEntity(postParameters, Constant.JSON_HEADER),String.class);
    }
}
