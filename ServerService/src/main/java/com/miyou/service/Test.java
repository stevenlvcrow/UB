package com.miyou.service;

import com.miyou.service.db.SchedualServiceHi;
import com.miyou.domain.BusinessContext;
import com.miyou.framework.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@BuinessBean(actionType = "login", name = "测试接口", reqClass = BusinessRequest.class, resClass = BusinessResponse.class)
@Component
@Slf4j
public class Test extends BuinessBridgeService {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Override
    public void process(BusinessContext context) throws BusinessException, IllegalArgumentException {
        schedualServiceHi.sayHiFromClientOne("dd");
    }
}
