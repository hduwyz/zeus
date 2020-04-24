package com.shiro.app2.controller;


import com.shiro.app2.biz.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    IAuthService authService;
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(@RequestParam String name) {
        return authService.sso(name);
    }
}
