package com.lagou.edu.mvcframework.annotations;

import java.lang.annotation.*;

/**
 * @author fgm
 * @description  权限验证
 * @date 2020-03-01
 ***/
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LagouSecurity {

    String value() default "";

}
