package com.miyou.controller;


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
    public UbUser getUserInfo(@RequestBody UbUser ubUser){
        Example<UbUser> example = Example.of(ubUser);
        ubUser = userInfoRespository.findOne(example);
        if(ubUser==null){
            return new UbUser();
        }
        return userInfoRespository.findOne(example);
    }

    @ResponseBody
    @PostMapping("/saveAndFlush")
    public Integer saveAndFlush(@RequestBody UbUser ubUser) {
        userInfoRespository.saveAndFlush(ubUser);
        return 1;
    }
}
