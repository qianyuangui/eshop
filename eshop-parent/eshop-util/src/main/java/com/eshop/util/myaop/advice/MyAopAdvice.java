package com.eshop.util.myaop.advice;

import org.springframework.stereotype.Component;

import com.eshop.util.myaop.annotation.AfterBaomw;
import com.eshop.util.myaop.annotation.AopJ;
import com.eshop.util.myaop.annotation.AroundBaomw;
import com.eshop.util.myaop.annotation.BeforeBaomw;

/**
 * 测试
 */
@AopJ
@Component
public class MyAopAdvice {

    @BeforeBaomw("com.eshop.util.myaop.dao")
    public void testBefore(){
        System.out.println("before   ------------------");
    }

    @AfterBaomw("com.eshop.util.myaop.dao")
    public void testAfter(){
        System.out.println("after   ------------------");
    }

    @AroundBaomw("com.eshop.util.myaop.dao")
    public void testAround(){
        System.out.println("around   ------------------");
    }
}
