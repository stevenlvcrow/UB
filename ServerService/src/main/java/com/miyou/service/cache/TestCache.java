package com.miyou.service.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
* @Author: lizhijie
* @Description: 需要做缓存的service （重要！！！）缓存的key必须是String类型，即所有方法的入参必须是String类型
* @Date: Created in 16:26 2018/5/29
*/
@Slf4j
@Service
public class TestCache {

    @CachePut(cacheNames = "user_cache", key = "#id")
    public String save(String id) {
        log.info("findById.id = " + id);
        return "更新了缓存";
    }

    @Cacheable(cacheNames = "user_cache", key = "#id")
    public String findById(String id) {
        log.info("findById.id = " + id);
        return "这个是存储的value";
    }

    @CacheEvict(cacheNames = "user_cache", key = "#id")
    public void delete(String id) {
        log.info("delete.id = " + id);

    }
}
