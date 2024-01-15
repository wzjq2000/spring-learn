package com.example.serverdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serverdemo.dto.Person;
import com.example.serverdemo.service.PersonService;
import com.example.serverdemo.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.datatransfer.StringSelection;

/**
* @author andy
* @description 针对表【person】的数据库操作Service实现
* @createDate 2023-12-31 09:53:06
*/
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person>
    implements PersonService{

    @Autowired
    PersonMapper personMapper;

    @Override
    public Person selectOne(Integer age) {
//        QueryWrapper<Person> selectOneWrapper = new QueryWrapper<>();
//        selectOneWrapper.eq("age",age);
//        return personMapper.selectOne(selectOneWrapper);

        return personMapper.selectByAge(10);
    }
}




