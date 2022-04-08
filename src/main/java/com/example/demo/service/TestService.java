package com.example.demo.service;

import com.example.demo.mapper.TestMapper;
import com.example.demo.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

    public TestModel get(int id) {
        return testMapper.get(id);
    }
}

