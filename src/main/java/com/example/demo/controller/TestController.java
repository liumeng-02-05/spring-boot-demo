package com.example.demo.controller;

import com.example.demo.common.BaseResult;
import com.example.demo.exceptions.MyException;
import com.example.demo.model.TestModel;
import com.example.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.HelloWorld;

@RestController
@RequestMapping("/testController")
@RestControllerAdvice
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestService testService;

    @RequestMapping("/get.action")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public TestModel get(@RequestParam("id") int id) {
        try {
            TestModel testModel = testService.get(id);
            logger.info("test controller");
            return testModel;
        }catch (Exception e) {
//            System.out.println("强制手动事务回滚");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return  null;

    }

    @GetMapping("/test.action")
    public BaseResult test() {
        int[] arr = {1,2,4};
        return BaseResult.success("获取接口成功");
    }

    @GetMapping("abnormal")
    public void testExt() {
        throw  new MyException("自定义异常信息");
    }
}
