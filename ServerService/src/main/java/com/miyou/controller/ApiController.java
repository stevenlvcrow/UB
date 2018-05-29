package com.miyou.controller;


import com.alibaba.fastjson.JSON;
import com.miyou.bean.LoginInfo;
import com.miyou.bean.TestVo;
import com.miyou.framework.BusinessResponse;
import com.miyou.framework.ProcessService;
import com.miyou.service.db.SchedualServiceHi;
import com.miyou.service.redis.CusRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping(value = "/www/api")
@CrossOrigin
public class ApiController {


    @Autowired
    ProcessService processService;

    @Autowired
    SchedualServiceHi schedualServiceHi;


    @Autowired
    CusRedisService redisService;


    @ResponseBody
    @RequestMapping("/{actionType}")
    public BusinessResponse action(@RequestBody String reqInStr, @PathVariable("actionType") String actionType, HttpServletRequest request){
        log.info("收到请求报文：\r\n{}",  reqInStr);
        return processService.jsonProcess(actionType,reqInStr,request);
    }

    @ResponseBody
    @RequestMapping("/login")
    public BusinessResponse login(@Validated @RequestBody  LoginInfo reqInStr){
        reqInStr.setLoginResponse("登录成功");
        return reqInStr;
    }

    @ResponseBody
    @RequestMapping("/loginOut")
    public BusinessResponse loginOut(HttpSession httpSession){
        httpSession.invalidate();
        return new BusinessResponse();
    }

    @ResponseBody
    @RequestMapping("/test")
    public BusinessResponse test(@RequestBody String reqInStr, HttpSession session){
        session.setAttribute("test","ppppp");
        System.out.println(session.getAttribute("test"));
        TestVo testVo = JSON.parseObject(reqInStr, TestVo.class);
        schedualServiceHi.sayHiFromClientOne(testVo.getId());
        log.info(testVo.toString());
        redisService.setObj("ke",reqInStr);
        log.info((String) redisService.getObj("ke"));
        return new BusinessResponse();
    }

}
