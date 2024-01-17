package com.example.serverdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestTemplateController {

    private Logger logger = LoggerFactory.getLogger(RestTemplateController.class);
    @GetMapping("/")
    public String solveIndex(@RequestHeader("key") String testId){
        logger.info("zzz");
        System.out.println(testId);
        return "THIS IS INDEX";
    }

}
