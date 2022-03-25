package com.example.demo.controller;

import com.example.demo.bean.DateBean;
import com.example.demo.common.BaseResult;
import com.example.demo.model.DemoModel;
import com.example.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/demo")
@RestControllerAdvice
@Api(value = "测试接口", tags = {"测试相关的api接口"})
public class DemoController {
    @Autowired
    DemoService demoService;

    @Autowired
    private DateBean dateBean;

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/ImportResource")
    public String index() {
        if(null == dateBean) {
            return "-";
        } else {
            return dateBean.init().getCurrentDate();
        }
    }
    @ApiOperation(value = "ApiOperation注解测试", notes = "ApiOperation注解测试", httpMethod = "GET")
    @GetMapping("/jiekou")
    public BaseResult demo(@RequestParam("id") int id) {
        return BaseResult.success(id+"获取接口成功");
    }

    @ApiOperation(value = "RequestBody", notes = "RequestBody", httpMethod = "POST")
    @PostMapping("/postDemo")
    public BaseResult login(@ApiParam(name = "用户信息", required = true) @RequestBody Object userMessage){
        return BaseResult.success("用户信息:" + userMessage);
    }


    @ApiOperation(value = "param注解测试", notes = "param注解测试", httpMethod = "GET")
    @GetMapping("/param")
    public DemoModel getUser(@RequestParam("id") int id) {
        logger.info("test controller");
        DemoModel demoModel = demoService.getUserId(id);
        return  demoModel;
    }
}
