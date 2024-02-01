package com.example.serverdemo.enhance;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class EnhancedTest {
    public static void main(String[] args) {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/andy/SelfLearn/JavaProjects2.0/spring-learn/server-demo");

        InvokeHandler invokeHandler = new InvokeHandler();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ToBeEnhanced.class);
        enhancer.setCallback(invokeHandler);

        ToBeEnhanced enhanced = (ToBeEnhanced) enhancer.create();
        enhanced.funcA();
        enhanced.funcB();
    }

}
