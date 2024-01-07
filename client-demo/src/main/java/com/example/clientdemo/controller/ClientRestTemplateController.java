package com.example.clientdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientRestTemplateController {
    String url = "http://localhost:8080";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/clientRestController")
    public void restTemplateTest() {

        String result = restTemplate.getForObject(url, String.class, "");

        System.out.println(result);

//        JSONObject jsonObject = new JSONObject();
//        ResponseEntity<JSONObject> jsonObjectResponseEntity = restTemplate.postForEntity(url, jsonObject, JSONObject.class);


    }

}
