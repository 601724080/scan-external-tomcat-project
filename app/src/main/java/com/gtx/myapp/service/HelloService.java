package com.gtx.myapp.service;

import org.springframework.stereotype.Service;

/**
 * Copyright (C) 2020-2022 杭州优诗科技有限公司
 * This file is part of UnitSpirit.
 * TODO
 *
 * @author gtx
 * @version 1.0.0
 * @Date 2023/9/13 9:58
 **/
@Service
public class HelloService {

    public String hello(String name){
        return "Hello " + name;
    }
}
