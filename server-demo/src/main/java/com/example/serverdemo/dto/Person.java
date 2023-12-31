package com.example.serverdemo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private Integer age;
}
