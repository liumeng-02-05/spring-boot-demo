package com.example.demo.service;

import com.example.demo.mapper.DemoMapper;
import com.example.demo.model.DemoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired
    private DemoMapper demoMapper;

    public DemoModel getUserId(int id) {
        return demoMapper.getId(id);
    }

}
