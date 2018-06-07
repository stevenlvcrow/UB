package com.miyou.controller;

import com.miyou.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Demo {

    @Autowired
    CustomerRepository customerRepository;

    public static final String  s = "123";

    @Value("${server.port}")
    private String port;

    @ResponseBody
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        customerRepository.findAll();
        return "hi "+name+",i am from port:" +port;
    }


}
