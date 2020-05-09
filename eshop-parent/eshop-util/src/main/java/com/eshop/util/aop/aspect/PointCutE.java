package com.eshop.util.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.eshop.util.myaop.annotation.BeforeBaomw;

/**
 *
 */
@Component
@Aspect
public class PointCutE {

	@Pointcut("execution(* com.eshop.util.aop.dao.*.*(..))")
	public void beforePointCut() {

	}

	@Pointcut("execution(* com.eshop.util.aop.dao.*.*(..))")
	public void afterPointCut() {

	}

	@Before("beforePointCut()")
	public void before() {
		System.out.println("before ...");
	}
	
	@After("afterPointCut()")
	public void after() {
		System.out.println("after ...");
	}

}
