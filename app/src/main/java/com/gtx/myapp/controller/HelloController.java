package com.gtx.myapp.controller;

import com.gtx.myapp.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class HelloController {
    @Resource
    private HelloService helloService;

    @GetMapping("hello")
    public String hello(String name){
        return helloService.hello(name);
    }

}
