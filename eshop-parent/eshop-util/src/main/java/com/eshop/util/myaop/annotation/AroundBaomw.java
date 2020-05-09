package com.eshop.util.myaop.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 描述: 自定义环绕通知处理注解类
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AroundBaomw {
	String value() default "";
}
