package com.atguigu.gulimall.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    @GetMapping("/world")
    public String World(){

        String msg = "world";
        return msg;
    }
}
