package com.example.serverdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Component
@Aspect
public class ToBeEnhancedAspect {
    @Pointcut("execution (* com.example.serverdemo.aop.ToBeEnhanced.*(..))")
    public void test(){}

    @Before("test()")
    public void beforeAdvice(){
        System.out.println("before...");

    }
}
