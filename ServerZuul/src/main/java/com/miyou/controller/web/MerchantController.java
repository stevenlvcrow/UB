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
@RequestMapping("/merchant")
public class MerchantController extends WebController{

    @ResponseBody
    @ApiOperation(value="商户列表查询", notes="返回商户列表集合")
    @ApiImplicitParam(name = "postParameters", value = "PaddingParam", required = true, dataType = "PaddingParam")
    @PostMapping("/list")
    public Object home(@RequestBody String postParameters) {
        return restTemplate.postForObject(Constant.SERVICEUTL+"/merchantList",new HttpEntity(postParameters, Constant.JSON_HEADER),String.class);
    }
}
