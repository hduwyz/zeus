package com.zeus.uaa.controller;


import com.zeus.uaa.entity.Role;
import com.zeus.uaa.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyz
 * @since 2020-04-24
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @PostMapping(value="/add")
    @ResponseBody
    public String add(String rolename, String description, String available) {
        Role role = new Role();
        role.setRole(rolename);
        role.setDescription(description);
        role.setAvailable(available);
        roleService.saveOrUpdate(role);
        return "Role add complete!";
    }
    @PostMapping(value="/delete")
    @ResponseBody
    public String delete(Integer roleId) {
        roleService.removeById(roleId);
        return "Roles delete complete!";
    }
}

