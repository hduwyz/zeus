package com.shiro.app2.biz;

import org.springframework.stereotype.Component;

@Component
public class AuthServiceHystric implements IAuthService {
    @Override
    public String sso(String name) {
        return "Sorry! " + name + " is not available!";
    }
}
