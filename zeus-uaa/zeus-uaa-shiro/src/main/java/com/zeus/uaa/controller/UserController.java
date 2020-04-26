package com.zeus.uaa.controller;


import com.zeus.core.model.Result;
import com.zeus.uaa.entity.User;
import com.zeus.uaa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyz
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping(value="/add")
    //@RequiresPermissions("system:user:config")
    public Result<String> add(String username, String password, String name, String phonenum) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setPhoneNum(phonenum);
        userService.createUser(user);
        return Result.succeed("User add complete!");
    }

    @PostMapping(value="/delete")
    public Result<String> delete(Integer userId) {
        userService.removeById(userId);
        return Result.succeed("Users delete complete!");
    }

    @PostMapping(value="/correlatroles")
    public Result<String> addRoles(@RequestParam("userId") Integer userId, @RequestParam("roleIds") List<Integer> roleIds) {
        userService.correlationRoles(userId, roleIds);
        return Result.succeed("Roles add to User complete!");
    }

    @PostMapping(value="/uncorrelatroles")
    public Result<String> deleteRoles(@RequestParam("userId") Integer userId,@RequestParam("roleIds")  List<Integer> roleIds) {
        userService.uncorrelationRoles(userId, roleIds);
        return Result.succeed("User's roles delete complete!");
    }
}

