package com.example.demo.mapper;


import com.example.demo.model.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestMapper {
    TestModel get(int id);
}
