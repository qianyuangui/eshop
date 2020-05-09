package com.eshop.util;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eshop.util.aop.config.Aopconfig;
import com.eshop.util.aop.dao.IndexDao;

/**
 * 测试
 */
public class AopTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = 
				new AnnotationConfigApplicationContext(Aopconfig.class);
		annotationConfigApplicationContext.getBean(IndexDao.class).query2();
		annotationConfigApplicationContext.getBean(IndexDao.class).query();
	}

}
