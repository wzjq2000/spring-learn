package com.example.serverdemo.enhance;

import org.springframework.cglib.proxy.Enhancer;

public class EnhancedTest {
    public static void main(String[] args) {
        InvokeHandler invokeHandler = new InvokeHandler();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ToBeEnhanced.class);
        enhancer.setCallback(invokeHandler);

        ToBeEnhanced enhanced = (ToBeEnhanced) enhancer.create();
        enhanced.funcA();
        enhanced.funcB();
    }

}
