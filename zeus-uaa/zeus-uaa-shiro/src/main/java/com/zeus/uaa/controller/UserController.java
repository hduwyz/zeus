package com.zeus.uaa.controller;


import com.zeus.uaa.entity.User;
import com.zeus.uaa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyz
 * @since 2020-04-24
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping(value="/add")
    //@RequiresPermissions("system:user:config")
    public String add(String username, String password, String name, String phonenum) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setPhoneNum(phonenum);
        userService.createUser(user);
        return "User add complete!";
    }

    @PostMapping(value="/delete")
    public String delete(Integer userId) {
        userService.removeById(userId);
        return "Users delete complete!";
    }

    @PostMapping(value="/correlatroles")
    public String addRoles(@RequestParam("userId") Integer userId, @RequestParam("roleIds") List<Integer> roleIds) {
        userService.correlationRoles(userId, roleIds);
        return "Roles add to User complete!";
    }

    @PostMapping(value="/uncorrelatroles")
    public String deleteRoles(@RequestParam("userId") Integer userId,@RequestParam("roleIds")  List<Integer> roleIds) {
        userService.uncorrelationRoles(userId, roleIds);
        return "User's roles delete complete!";
    }
}

