package com.eshop.util.myaop.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.eshop.util.myaop.processor.RealizedAopBeanPostProcessor;
import com.eshop.util.myaop.processor.RegisterBeanFactoryPostProcessor;

/**
 * 描述:
 * 自定义aop实现，提交给spring处理的类
 */
public class CustomizedAopImportSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{RealizedAopBeanPostProcessor.class.getName(),RegisterBeanFactoryPostProcessor.class.getName()};
    }
}
