package com.Rioa.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class textController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello,csd!";
    }
}
