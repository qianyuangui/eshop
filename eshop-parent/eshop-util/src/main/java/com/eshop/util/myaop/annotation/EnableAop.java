package com.eshop.util.myaop.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.context.annotation.Import;

import com.eshop.util.myaop.selector.CustomizedAopImportSelector;

/**
 * 注解开关：
 * 借助@Import注解，可以动态实现将一个类是否交由spring管理，常用作开关操作
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(CustomizedAopImportSelector.class)
public @interface EnableAop {
}
