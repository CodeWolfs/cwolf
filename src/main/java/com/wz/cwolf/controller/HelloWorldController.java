package com.wz.cwolf.controller;

import com.wz.cwolf.common.aspect.LogAspect;
import com.wz.cwolf.common.result.Result;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Api(tags = "HelloWorld")
@RequestMapping("/hello")
public class HelloWorldController {

    private final static Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/test")
    public Result<?> test(String password,String file,String userName) {
        LOG.info("password: {}",password);
        LOG.info("file: {}",file);
        LOG.info("userName: {}",userName);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","test");
        map.put("password",password);
        map.put("file",file);
        map.put("git","测试");
        return Result.ok(map);
    }
}
