package com.miyou.controller;

import com.miyou.repository.CustomerRepository;
import com.miyou.MiyouUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

    @Autowired
    CustomerRepository customerRepository;

    @Value("${server.port}")
    private String port;

    @ResponseBody
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        MiyouUser miyouUser = new MiyouUser();
        customerRepository.findAll();
//        String outParam = customerRepository.deleteTestCase("1","1","1","1");
//        System.out.println(outParam);
        return "hi "+name+",i am from port:" +port;
    }
}
