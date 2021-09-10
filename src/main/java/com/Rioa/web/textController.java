package com.Rioa.web;

import com.Rioa.po.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class textController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello,csd!";
    }
    @GetMapping("/user/get")
    public User getUser(){
        User test_1 = new User();
        test_1.setUsername("user01");
        test_1.setPassword("01password");
        return test_1;
    }
}
