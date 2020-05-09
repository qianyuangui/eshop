package com.eshop.util.myaop.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.eshop.util.myaop.holder.ProxyBeanHolder;

/**
 * 
 */
public class ConfigurationUtil {

	/**
	 * aop标识注解类
	 */
	public static final String AOP_POINTCUT_ANNOTATION = "com.eshop.util.myaop.annotation.AopJ";
	/**
	 * 前置通知注解类
	 */
	public static final String BEFORE = "com.eshop.util.myaop.annotation.BeforeBaomw";
	/**
	 * 后置通知注解类
	 */
	public static final String AFTER = "com.eshop.util.myaop.annotation.AfterBaomw";
	/**
	 * 环绕通知注解类
	 */
	public static final String AROUND = "com.eshop.util.myaop.annotation.AroundBaomw";
	/**
	 * 存放需代理的全部目标对象类
	 */
	public static volatile Map<String, List<ProxyBeanHolder>> classzzProxyBeanHolder = new ConcurrentHashMap<>();

}
