package com.miyou.framework;

import com.miyou.constant.BusinessConstant;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
* @Author: lizhijie
* @Description: 服务注册
* @Date: Created in 16:42 2018/5/25
*/
@Slf4j
public class ServiceRegistry {
    private static ConcurrentHashMap<String, BusinessService> registry = new ConcurrentHashMap<String, BusinessService>();

    public static void addService(String actionType, BusinessService service) {

        if (actionType == null || actionType.length() == 0)
            throw new IllegalArgumentException("msgType cannot be null");
        String key = actionType;

        BusinessService existingService = registry.get(key);
        if (existingService != null) {
            log.warn("服务{}跟已注册服务{}冲突，key={}。", service.getName(),
                    existingService.getName(), key);
        }
        registry.put(key, service);
       log.info("注册服务: {}, {}", key, service.getName());
    }

    static BusinessService getService(String actionType)
            throws BusinessException {
        if (actionType == null || actionType.length() == 0)
            throw new IllegalArgumentException("msgType cannot be null");
        String key;
        BusinessService service;
        key = actionType;
        service = registry.get(key);

        if (service != null)
            return service;

        throw new BusinessException(BusinessConstant.ERR_CODE.FATAL, "不支持该业务");
    }

}
