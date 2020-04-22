package com.zeus.demo.controller;

import com.zeus.core.model.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @PostMapping("/test")
    public Result testHello(@RequestParam String msg, HttpSession httpSession){
        System.out.println("---------------------");
        int count = (Integer) httpSession.getAttribute("count");
//        if (true){
//            throw new RuntimeException("jlajfla");
//        }
        return Result.succeed(true);
    }
}
