package com.miyou.controller;

import com.miyou.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class  HiController {

    @Autowired
    private SchedualServiceHi schedualServiceHi;


    @ResponseBody
    @GetMapping("/hi")
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }

}
