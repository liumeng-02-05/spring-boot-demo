package com.example.demo.mapper;

import com.example.demo.model.DemoModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DemoMapper {
    DemoModel getId(@Param("id") int id);
}
