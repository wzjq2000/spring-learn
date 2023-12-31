package com.example.serverdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serverdemo.dto.Person;

/**
* @author andy
* @description 针对表【person】的数据库操作Service
* @createDate 2023-12-31 09:53:06
*/
public interface PersonService extends IService<Person> {

    Person selectOne(Integer age);
}
