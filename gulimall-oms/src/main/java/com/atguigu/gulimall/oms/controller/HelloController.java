package com.atguigu.gulimall.oms.controller;

import com.atguigu.gulimall.oms.feign.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Autowired
    WorldService worldService;
    @Value("${my.content}")
    private String content = "";

    @GetMapping("/hello")
    public String hello(){
         String msg = "";
         msg=worldService.world();
         return "hello "+msg+content;
     }
}
