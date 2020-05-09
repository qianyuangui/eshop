package com.eshop.util.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.eshop.util.myaop.annotation.EnableAop;

/**
 * 
 */
@Configuration
@ComponentScan("com.eshop.util.myaop")
@EnableAspectJAutoProxy
@EnableAop//开启aop注解
public class Aopconfig {

}
