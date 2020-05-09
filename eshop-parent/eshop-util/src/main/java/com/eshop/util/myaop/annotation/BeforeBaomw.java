package com.eshop.util.myaop.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 描述: 自定义前置通知注解类
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface BeforeBaomw {
	String value() default "";
}
