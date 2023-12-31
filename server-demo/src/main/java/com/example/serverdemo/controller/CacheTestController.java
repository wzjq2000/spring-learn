package com.example.serverdemo.controller;

import com.example.serverdemo.dto.Person;
import com.example.serverdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CacheTestController {

    @Autowired
    PersonService personService;
    @GetMapping("/selectOne/{age}")
    public Person selectOne(@PathVariable Integer age){
        return personService.selectOne(age);
    }

}
