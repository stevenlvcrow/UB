package com.miyou.controller;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miyou.bean.LoginInfo;
import com.miyou.bean.TestVo;
import com.miyou.domain.BusinessResponse;
import com.miyou.domain.PaddingParam;
import com.miyou.framework.ProcessService;
import com.miyou.service.cache.TestCache;
import com.miyou.service.db.SchedualServiceHi;
import com.miyou.tableVo.UbTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

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
    TestCache testCache;


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
        log.info(""+session.getAttribute("test"));
        TestVo testVo = JSON.parseObject(reqInStr, TestVo.class);

        PaddingParam req = new PaddingParam();
        req.setPage(1);
        req.setSize(5);
        req.setSort("name");
        req.setTableBean(testVo);

        // 这里无法用Page对象接收，只能使用 LinkedHashMap 接收
        Object obj =  schedualServiceHi.merchantListPadding(req);
        LinkedHashMap pageResult = (LinkedHashMap) obj;
        testCache.findById("a");
        return new BusinessResponse(pageResult);
    }

}
