package com.miyou.controller;


import com.miyou.repository.CustomerRepository;
import com.miyou.tableVo.UbTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    CustomerRepository customerRepository;

    @ResponseBody
    @PostMapping("/listPadding")
    public Page<UbTest> listPadding(){

        Pageable pageable = new PageRequest(0,3, Sort.Direction.DESC,"id");
        Example<UbTest> example = Example.of(new UbTest());
        return customerRepository.findAll(example,pageable);
    }
}
