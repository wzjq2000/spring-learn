package com.example.serverdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestTemplateController {
    @GetMapping("/")
    public String solveIndex(){
        return "THIS IS INDEX";
    }

}
