package com.javaboy.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/employee/basic/hello")
    public String hello() {
        return "hello basic";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello2() {
        return "hello advanced";
    }
}
