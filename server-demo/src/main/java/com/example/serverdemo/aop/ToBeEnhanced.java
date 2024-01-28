package com.example.serverdemo.aop;


import org.springframework.stereotype.Component;

@Component
public class ToBeEnhanced {
    public void funcA(){
        System.out.println("A");
    }
    public void funcB(){
        System.out.println("B");
    }
}
