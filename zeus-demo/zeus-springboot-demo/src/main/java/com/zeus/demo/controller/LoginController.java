package com.zeus.demo.controller;

import com.zeus.core.handler.SessionCounterListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String userName, HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute(userName, userName);
        AtomicInteger userCount = SessionCounterListener.userCount;
        log.info(userName + "上线成功！当前在线人数： " + userCount);
        return userName + "上线成功！当前在线人数： " + userCount;
    }

    @PostMapping("/logout")
    @ResponseBody
    public String logout(@RequestParam String userName, HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        httpSession.removeAttribute(userName);
        httpSession.invalidate();
        AtomicInteger userCount = SessionCounterListener.userCount;
        log.info(userName + "下线成功！当前在线人数： " + userCount);
        return userName + "下线成功！当前在线人数：" + userCount;
    }
}
