package com.shiro.app1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Value("${server.port}")
    String port;
    @RequestMapping("/auth")
    public String home(@RequestParam(value = "name", defaultValue = "sso") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
