package com.zeus.uaa.controller;


import com.zeus.uaa.biz.ShiroService;
import com.zeus.uaa.entity.Permission;
import com.zeus.uaa.service.IPermissionService;
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
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    IPermissionService permissionService;
    @Autowired
    ShiroService shiroService;

    @PostMapping(value="/add")
    @ResponseBody
    public String add(String url, String perms, Integer sort, String description) {
        Permission permission = new Permission();
        permission.setUrl(url);
        permission.setPermission(perms);
        permission.setDescription(description);
        permission.setSort(sort);
        permissionService.saveOrUpdate(permission);
        shiroService.updatePermission();
        return "Permission add complete!";
    }
    @PostMapping(value="/delete")
    @ResponseBody
    public String delete(Integer permissionId) {
        permissionService.removeById(permissionId);
        shiroService.updatePermission();
        return "Permissions delete complete!";
    }
}

