package com.eshop.util.myaop.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

import com.eshop.util.myaop.util.ConfigurationUtil;

/**
 * 描述:
 * aop实现核心处理类
 */
public class RealizedAopBeanPostProcessor implements BeanPostProcessor {


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        String targetClass = bean.getClass().getName();
        System.out.println("postprocess before init....");
        Object object = bean;
        if (ConfigurationUtil.classzzProxyBeanHolder.containsKey(targetClass)){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(object.getClass());
            enhancer.setCallback(new CustomizedProxyInterceptor(ConfigurationUtil.classzzProxyBeanHolder.get(targetClass)));
            object =  enhancer.create();
        }
        return object;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
