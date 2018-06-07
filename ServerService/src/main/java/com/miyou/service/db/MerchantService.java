package com.miyou.service.db;


import com.miyou.domain.PaddingParam;
import com.miyou.tableVo.UbMerchant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;

@Service
@FeignClient(value = "service-db")
public interface MerchantService {

    @RequestMapping(value = "/merchant/listPadding",method = RequestMethod.POST)
    LinkedHashMap merchantListPadding(@RequestBody PaddingParam paddingParam);

    @RequestMapping(value = "/merchant/saveAndFlush",method = RequestMethod.POST)
    Integer merchantSaveAndFlush(@RequestBody UbMerchant ubMerchant);

    @RequestMapping(value = "/merchant/del",method = RequestMethod.POST)
    Integer merchantDel(@RequestBody String ids[]);
}
