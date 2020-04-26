package com.zeus.uaa.controller;

import com.zeus.core.model.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value="login")
    public Result<String> submitLogin(String username, String password, Boolean rememberMe) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        //用户登录
        SecurityUtils.getSubject().login(token);
        return Result.succeed("登录成功");
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value="logout",method =RequestMethod.GET)
    @ResponseBody
    public Result<String> logout(){
        //用户退出
        SecurityUtils.getSubject().logout();
        return Result.succeed("退出成功");
    }
}

