package com.example.serverdemo.pojo;


public class User implements UserMBean {

    private String name;

    private Integer age;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.err.println("set name to " + name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.err.println("set age to " + age);
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.err.println("set address to " + address);
        this.address = address;
    }

    public String sayHello() {
        return "Hello!";
    }

}

