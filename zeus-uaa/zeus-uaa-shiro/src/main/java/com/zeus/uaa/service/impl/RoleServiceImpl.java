package com.zeus.uaa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeus.uaa.entity.Role;
import com.zeus.uaa.entity.RolePermission;
import com.zeus.uaa.mapper.RoleMapper;
import com.zeus.uaa.mapper.RolePermissionMapper;
import com.zeus.uaa.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Role> findByUserId(Integer uid){
        List<Role> roles = roleMapper.findRolesByUserId(uid);
        return roles;
    }
    @Override
    public void correlationPermissions(Integer roleId, List<Integer> permissionIdList){
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(roleId);
        for (Integer permissionId:permissionIdList) {
            rolePermission.setPermissionId(permissionId);
            rolePermissionMapper.insert(rolePermission);
        }
    }
    @Override
    public void uncorrelationPermissions(Integer roleId, List<Integer> permissionIdList){
        QueryWrapper qw = new QueryWrapper();
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(roleId);
        for (Integer permissionId:permissionIdList) {
            rolePermission.setPermissionId(permissionId);
            qw.setEntity(rolePermission);
            rolePermissionMapper.delete(qw);
        }
    }
}
