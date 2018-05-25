package com.miyou.controller;


import com.miyou.framework.ProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping(value = "/www/api")
public class ApiController {


    @Autowired
    ProcessService processService;

    @ResponseBody
    @RequestMapping("/{actionType}")
    public String action(@RequestBody String reqInStr, @PathVariable("actionType") String actionType, HttpServletRequest request){
        log.info("收到请求报文：\r\n{}",  reqInStr);
        processService.jsonProcess(actionType,reqInStr,request);
        return "";
    }
}
