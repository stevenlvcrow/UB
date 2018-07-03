package com.miyou.controller;


import com.miyou.domain.BusinessResponse;
import com.miyou.framework.BusinessException;
import com.miyou.repository.UserInfoRespository;
import com.miyou.tableVo.UbUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoRespository userInfoRespository;


    @ResponseBody
    @PostMapping("/getUserInfo")
    public BusinessResponse getUserInfo(@RequestBody UbUser ubUser){
        BusinessResponse businessResponse = new BusinessResponse();
//        Example<UbUser> example = Example.of(ubUser);
//        ubUser = userInfoRespository.findOne(example);
//        if(ubUser==null){
//            businessResponse.setResponseData(new UbUser());
//            return businessResponse;
//        }
//        businessResponse.setResponseData(ubUser);
        return businessResponse;
    }

    @ResponseBody
    @PostMapping("/saveAndFlush")
    public BusinessResponse saveAndFlush(@RequestBody UbUser ubUser) throws BusinessException {
        BusinessResponse businessResponse = new BusinessResponse();
        Example<UbUser> example = Example.of(ubUser);
//        UbUser ubUser1 = userInfoRespository.findOne(example);
//        if(ubUser1!=null){
//            throw new BusinessException("9999","已存在的用户");
//        }
//        BusinessResponse businessResponse = new BusinessResponse();
//        userInfoRespository.saveAndFlush(ubUser);
        return businessResponse;
    }
}
