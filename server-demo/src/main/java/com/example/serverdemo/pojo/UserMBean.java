package com.example.serverdemo.pojo;

public interface UserMBean {
    String getName();

    void setName(String name);

    Integer getAge();

    void setAge(Integer age);

    String getAddress();

    void setAddress(String address);

    String sayHello();

}
