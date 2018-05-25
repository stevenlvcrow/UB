package com.miyou.controller;


import com.miyou.service.SchedualServiceHi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ApiController {


    @Autowired
    private SchedualServiceHi schedualServiceHi;


    @ResponseBody
    @RequestMapping("/{actionType}")
    public String sayHi(@RequestBody String reqInStr, @PathVariable("actionType") String actionType){
        log.info("收到请求报文：\r\n{}",  reqInStr);
        return "";
    }
}
