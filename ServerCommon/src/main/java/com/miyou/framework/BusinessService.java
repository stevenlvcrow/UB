package com.miyou.framework;

import com.miyou.domain.BusinessContext;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;

public abstract class BusinessService {

    @Setter
    @Getter
    private String          actionType;

    @Setter
    @Getter
    private String          name;

    @Setter
    @Getter
    private BusinessRequest businessRequest;

    @Setter
    @Getter
    private BusinessResponse businessResponse;

    public abstract void process(BusinessContext context) throws BusinessException,IllegalArgumentException;

    @PostConstruct
    public void init() {
        // 注册服务
        if (getActionType() != null)
            ServiceRegistry.addService(getActionType(), this);
    }
}
