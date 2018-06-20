package com.miyou.service.db;

import com.miyou.domain.BusinessResponse;
import com.miyou.tableVo.UbUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient(value = "service-db")
public interface UserInfoService {

    @RequestMapping(value = "/userInfo/saveAndFlush",method = RequestMethod.POST)
    BusinessResponse userSaveAndFlush(@RequestBody UbUser ubUser);

    @RequestMapping(value = "/userInfo/getUserInfo",method = RequestMethod.POST)
    BusinessResponse getUserInfo(@RequestBody UbUser ubUser);
}
