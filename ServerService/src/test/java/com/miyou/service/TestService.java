package com.miyou.service;

import com.alibaba.fastjson.JSON;
import com.miyou.bean.TestVo;
import com.miyou.domain.BusinessContext;
import com.miyou.domain.PaddingParam;
import com.miyou.utils.RSAUtil;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.Map;


public class TestService extends BizTest{


    @Test
    public void test() throws Exception {

        PaddingParam req = new PaddingParam();
        req.setPage(1);
        req.setSize(5);

        TestVo testVo = new TestVo();
        testVo.setName("a");

        req.setTableBean(testVo);

        String actionType="login";
        Map<String, Object> map = RSAUtil.genKeyPair();
        String publicKey = RSAUtil.getPublicKey(map);
        String privateKey = RSAUtil.getPrivateKey(map);


        String token = getToken(req,publicKey);

        request = new MockHttpServletRequest();
        request.addHeader("token",token);
        BusinessContext context=new BusinessContext();
        context.setBusinessRequest(req);
        context.setBusinessResponse( processService.jsonProcess(actionType, JSON.toJSONString(req),request));
        printResult(context,"会员列表");
    }
}
