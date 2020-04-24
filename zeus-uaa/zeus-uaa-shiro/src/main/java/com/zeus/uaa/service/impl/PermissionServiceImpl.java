package com.zeus.uaa.service.impl;

import com.zeus.uaa.entity.Permission;
import com.zeus.uaa.entity.Role;
import com.zeus.uaa.mapper.PermissionMapper;
import com.zeus.uaa.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyz
 * @since 2020-04-24
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> findByRoles(List<Role> roleList) {
        List<Permission> permissionList = permissionMapper.findPermissionsByRoles(roleList);
        return permissionList;
    }
}
