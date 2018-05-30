package com.miyou.service.db;

import com.miyou.domain.PaddingParam;
import com.miyou.tableVo.UbTest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "service-db")
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/merchant/listPadding",method = RequestMethod.POST)
    Page<UbTest> merchantListPadding(@RequestBody PaddingParam paddingParam);
}
