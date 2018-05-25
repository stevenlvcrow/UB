package com.miyou.framework;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
* @Author: lizhijie
* @Description: 用于对bean做验签的注解
* @Date: Created in 17:31 2018/5/15
*/
@Constraint(validatedBy = TokenValidator.class) //具体的实现
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface TokenVerify {

    String message() default "参数签名校验失败"; //提示信息,可以写死,可以填写国际化的key

    int length() default 5;

    //下面这两个属性必须添加
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
