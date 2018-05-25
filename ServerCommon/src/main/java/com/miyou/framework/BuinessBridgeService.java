package com.miyou.framework;

import lombok.extern.slf4j.Slf4j;

/**
* @Author: lizhijie
* @Description: 使用注解注册服务
* @Date: Created in 16:44 2018/5/25
*/
@Slf4j
public abstract class BuinessBridgeService extends BusinessService {

    private String actionType;
    private String name;
    private BusinessRequest businessRequest;
    private BusinessResponse businessResponse;

    protected BuinessBridgeService() {
        if (this.getClass().isAnnotationPresent(BuinessBean.class)) {
            BuinessBean annotation = this.getClass().getAnnotation(BuinessBean.class);
            //获取注解的属性值
            this.actionType = annotation.actionType();
            this.name = annotation.name();
            try {
                this.businessRequest = (BusinessRequest) annotation.reqClass().newInstance();
                this.businessResponse = (BusinessResponse) annotation.resClass().newInstance();
            } catch (Exception e) {
                log.error("错误的转换类型", e);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public String getActionType() {
        return this.actionType;
    }

    public BusinessRequest getBusinessRequest() {
        return this.businessRequest;
    }

    public BusinessResponse getBusinessResponse() {
        return this.businessResponse;
    }
}
