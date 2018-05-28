package com.miyou.controller.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b")
public class WebController {

    @ResponseBody
    @RequestMapping("/test")
    public Object home() {
        return "home";
    }
}
