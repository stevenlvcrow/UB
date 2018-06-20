package com.miyou.service.business;


import com.miyou.bean.UserSaveRequest;
import com.miyou.domain.BusinessContext;
import com.miyou.domain.BusinessResponse;
import com.miyou.framework.BuinessBean;
import com.miyou.framework.BuinessBridgeService;
import com.miyou.framework.BusinessException;
import com.miyou.service.db.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@BuinessBean(actionType = "saveUser", name = "添加用户", reqClass = UserSaveRequest.class, resClass = BusinessResponse.class)
@Service
@Slf4j
public class UserInfoSave extends BuinessBridgeService {

    @Autowired
    UserInfoService userInfoService;

    @Override
    public void process(BusinessContext context) throws BusinessException, IllegalArgumentException {
        UserSaveRequest userSaveRequest = (UserSaveRequest) context.getBusinessRequest();
        BusinessResponse businessResponse = userInfoService.userSaveAndFlush(userSaveRequest.getUbUser());
        context.setBusinessResponse(businessResponse);
    }
}
