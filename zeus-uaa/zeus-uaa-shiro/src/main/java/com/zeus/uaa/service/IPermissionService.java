package com.zeus.uaa.service;

import com.zeus.uaa.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zeus.uaa.entity.Role;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyz
 * @since 2020-04-24
 */
public interface IPermissionService extends IService<Permission> {
    List<Permission> findByRoles(List<Role> roleList);

}
