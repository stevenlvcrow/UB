package com.miyou.controller;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miyou.domain.PaddingParam;
import com.miyou.repository.MerchantRepository;
import com.miyou.tableVo.UbMerchant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantRepository merchantRepository;

    @ResponseBody
    @PostMapping("/listPadding")
    public Page<UbMerchant> listPadding(@RequestBody PaddingParam paddingParam) {
        Pageable pageable = new PageRequest(paddingParam.getPage(), paddingParam.getSize(), Sort.Direction.DESC, paddingParam.getSort());
        //Pageable pageable = new PageRequest(paddingParam.getPage(), paddingParam.getSize());
        Object tableBean = paddingParam.getTableBean();
        Example<UbMerchant> example;
        Page<UbMerchant> page;
        if(tableBean!=null){
            UbMerchant ubTest = new ObjectMapper().convertValue(paddingParam.getTableBean(), UbMerchant.class);
            example = Example.of(ubTest);
            page = merchantRepository.findAll(example,pageable);
        }else{
            page = merchantRepository.findAll(pageable);
        }
        return page;
    }


    @ResponseBody
    @PostMapping("/saveAndFlush")
    public Integer saveAndFlush(@RequestBody UbMerchant ubMerchant) {
        merchantRepository.saveAndFlush(ubMerchant);
        return 1;
    }

    @ResponseBody
    @PostMapping("/del")
    public Integer del(@RequestBody String ids[]) {
        List<UbMerchant> ubMerchantList = new ArrayList<>();
        for (String id : ids) {
            UbMerchant ubMerchant = new UbMerchant();
            ubMerchant.setId(id);
            Example<UbMerchant> example = Example.of(ubMerchant);
            ubMerchant = merchantRepository.findOne(example);
            ubMerchantList.add(ubMerchant);
        }
        merchantRepository.deleteInBatch(ubMerchantList);
        return 1;
    }
}
