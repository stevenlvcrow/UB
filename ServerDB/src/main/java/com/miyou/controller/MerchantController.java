package com.miyou.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.miyou.domain.PaddingParam;
import com.miyou.repository.CustomerRepository;
import com.miyou.tableVo.UbTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    CustomerRepository customerRepository;

    @ResponseBody
    @PostMapping("/listPadding")
    public Page<UbTest> listPadding(@RequestBody PaddingParam paddingParam){
        Pageable pageable = new PageRequest(paddingParam.getPage(),paddingParam.getSize(), Sort.Direction.DESC,paddingParam.getSort());
        UbTest ubTest =  new ObjectMapper().convertValue(paddingParam.getTableBean(),UbTest.class);
        Example<UbTest> example = Example.of(ubTest);
        return customerRepository.findAll(example,pageable);
    }
}
