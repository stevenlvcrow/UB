package com.miyou.framework;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhuhongqing on 2018/5/9.
 */
public class ServiceRegistry {
    private static ConcurrentHashMap<String, BusinessService> registry = new ConcurrentHashMap<String, BusinessService>();

    public static void addService(String actionType, BusinessService service) {

        if (actionType == null || actionType.length() == 0)
            throw new IllegalArgumentException("msgType cannot be null");
        String key = actionType;

        BusinessService existingService = registry.get(key);
        if (existingService != null) {
//            log.warn("服务{}跟已注册服务{}冲突，key={}。", service.getName(),
//                    existingService.getName(), key);
        }
        registry.put(key, service);

//        log.info("注册服务: {}, {}", key, service.getName());
    }

    public static BusinessService getService(String actionType)
            throws BusinessException {
        if (actionType == null || actionType.length() == 0)
            throw new IllegalArgumentException("msgType cannot be null");
        String key = null;
        BusinessService service = null;
        key = actionType;
        service = registry.get(key);

        if (service != null)
            return service;

        throw new BusinessException(BusinessConstant.ERR_CODE.FATAL, "不支持该业务");
    }

}
