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
@RequestMapping("/userInfo")
public class UserInfoController extends WebController{

    @ResponseBody
    @ApiOperation(value="获取用户信息", notes="返回用户的实例对象")
    @ApiImplicitParam(name = "getUserInfo", value = "UserInfo", required = true, dataType = "UbUser")
    @PostMapping("/getUserInfo")
    public Object getUserInfo(@RequestBody String postParameters) {
        return restTemplate.postForObject(Constant.SERVICEUTL+"/getUserInfo",new HttpEntity(postParameters, Constant.JSON_HEADER),String.class);
    }

    @ResponseBody
    @ApiOperation(value="保存用户信息", notes="新增或者修改用户")
    @ApiImplicitParam(name = "saveUser", value = "UserInfo", required = true, dataType = "UbUser")
    @PostMapping("/saveUser")
    public Object saveUser(@RequestBody String postParameters) {
        return restTemplate.postForObject(Constant.SERVICEUTL+"/saveUser",new HttpEntity(postParameters, Constant.JSON_HEADER),String.class);
    }
}
