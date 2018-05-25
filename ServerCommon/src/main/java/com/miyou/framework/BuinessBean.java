package com.miyou.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Author: lizhijie
* @Description: 注册服务的注解实现
* @Date: Created in 17:33 2018/5/15
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BuinessBean {

    String name();
    String actionType();
    Class reqClass();
    Class resClass();

}
