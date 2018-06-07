package com.miyou.service.business;

import com.miyou.bean.JustIdRequest;
import com.miyou.domain.BusinessContext;
import com.miyou.domain.BusinessResponse;
import com.miyou.framework.BuinessBean;
import com.miyou.framework.BuinessBridgeService;
import com.miyou.framework.BusinessException;
import com.miyou.service.db.UserInfoService;
import com.miyou.tableVo.UbUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@BuinessBean(actionType = "getUserInfo", name = "获取用户信息", reqClass = JustIdRequest.class, resClass = BusinessResponse.class)
@Service
@Slf4j
public class UserInfoGet extends BuinessBridgeService {

    @Autowired
    UserInfoService userInfoService;

    @Override
    public void process(BusinessContext context) throws BusinessException, IllegalArgumentException {
        JustIdRequest justIdRequest = (JustIdRequest) context.getBusinessRequest();
        UbUser ubUser = new UbUser();
        ubUser.setId(justIdRequest.getId());
        ubUser = userInfoService.getUserInfo(ubUser);
        BusinessResponse businessResponse = new BusinessResponse();
        businessResponse.setResponseData(ubUser);
        context.setBusinessResponse(businessResponse);
    }
}
