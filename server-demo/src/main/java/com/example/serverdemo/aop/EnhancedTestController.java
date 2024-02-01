package com.example.serverdemo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EnhancedTestController {

    @Autowired
    ToBeEnhanced toBeEnhanced;

    @GetMapping("/enhanced")
    public String enhanceTest(){
        toBeEnhanced.funcA();
        toBeEnhanced.funcB();
        return "ok";
    }

}
