package com.wz.cwolf.controller;

import com.wz.cwolf.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "HelloWorld")
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("/test")
    public Result<?> test() {
        return Result.ok();
    }
}
