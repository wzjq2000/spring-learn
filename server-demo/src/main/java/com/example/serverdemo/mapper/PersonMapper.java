package com.example.serverdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.serverdemo.dto.Person;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author andy
 * @description 针对表【person】的数据库操作Mapper
 * @createDate 2023-12-31 09:53:06
 * @Entity generator.domain.Person
 */
@Mapper
@CacheNamespace
public interface PersonMapper extends BaseMapper<Person> {


}




