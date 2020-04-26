package com.zeus.uaa.controller;


import com.zeus.core.model.Result;
import com.zeus.uaa.service.impl.ShiroService;
import com.zeus.uaa.entity.Permission;
import com.zeus.uaa.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyz
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    IPermissionService permissionService;

    @Autowired
    ShiroService shiroService;

    @PostMapping(value="/add")
    public Result<String> add(String url, String perms, Integer sort, String description) {
        Permission permission = new Permission();
        permission.setUrl(url);
        permission.setPermission(perms);
        permission.setDescription(description);
        permission.setSort(sort);
        permissionService.saveOrUpdate(permission);
        shiroService.updatePermission();
        return Result.succeed("Permission add complete!");
    }

    @PostMapping(value="/delete")
    public Result<String> delete(Integer permissionId) {
        permissionService.removeById(permissionId);
        shiroService.updatePermission();
        return Result.succeed("Permissions delete complete!");
    }
}

