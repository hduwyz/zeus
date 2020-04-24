package com.shiro.app2.biz;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//指定需调用的服务
@FeignClient(value = "zeus-uaa", fallback = AuthServiceHystric.class)
public interface IAuthService {
    //指定调用服务中的接口
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    String sso(@RequestParam(value = "name") String name);
}
