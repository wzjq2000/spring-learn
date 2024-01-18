package com.example.serverdemo.mbean;

public interface UserMBean {
    String getName();

    void setName(String name);

    Integer getAge();

    void setAge(Integer age);

    String getAddress();

    void setAddress(String address);

    String sayHello();

}
