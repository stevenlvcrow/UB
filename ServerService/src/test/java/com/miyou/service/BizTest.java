package com.miyou.service;

import com.alibaba.fastjson.JSON;
import com.miyou.ServiceApp;
import com.miyou.domain.BusinessContext;
import com.miyou.domain.BusinessRequest;
import com.miyou.domain.BusinessResponse;
import com.miyou.framework.ProcessService;
import com.miyou.utils.RSAUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.MessageDigest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class BizTest {


    public MockHttpServletRequest request;
    public MockHttpServletResponse response;

    @Autowired
    ProcessService processService;

    void printResult(BusinessContext context, String name) {

        BusinessRequest businessRequest = context.getBusinessRequest();
        String reqInStr = JSON.toJSONString(businessRequest);
        System.out.println(name + "请求reqInStr:\n " + reqInStr);

        BusinessResponse businessResponse = context.getBusinessResponse();
        String resInStr = JSON.toJSONString(businessResponse);
        System.out.println(name + "返回resInStr:\n " + resInStr);
    }

    String getToken(Object bean, String publicKey) throws Exception {
        String json = JSON.toJSONString(bean);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(json.getBytes("UTF-8"));
        String encdeStr = Hex.encodeHexString(hash);
        encdeStr = encdeStr+"#asso#";
        return RSAUtil.encryptByPublicKeyString(encdeStr, publicKey);

    }


}
