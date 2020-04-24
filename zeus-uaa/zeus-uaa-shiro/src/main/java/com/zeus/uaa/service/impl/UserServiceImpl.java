package com.zeus.uaa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeus.uaa.utils.PasswordHelper;
import com.zeus.uaa.entity.Permission;
import com.zeus.uaa.entity.Role;
import com.zeus.uaa.entity.User;
import com.zeus.uaa.entity.UserRole;
import com.zeus.uaa.mapper.UserMapper;
import com.zeus.uaa.mapper.UserRoleMapper;
import com.zeus.uaa.service.IPermissionService;
import com.zeus.uaa.service.IRoleService;
import com.zeus.uaa.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyz
 * @since 2020-04-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public User createUser(User user){
        PasswordHelper passwordHelper = new PasswordHelper();
        passwordHelper.encryptPassword(user);
        userMapper.insert(user);
        return user;
    }

    @Override
    public void changePassword(Integer userId, String newPassword){
        User user = userMapper.selectById(userId);
        user.setPassword(newPassword);
        PasswordHelper passwordHelper = new PasswordHelper();
        passwordHelper.encryptPassword(user);
        userMapper.updateById(user);
    }

    @Override
    public void correlationRoles(Integer userId, List<Integer> roleIds){
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        for (Integer roleId:roleIds) {
            userRole.setRoleId(roleId);
            userRoleMapper.insert(userRole);
        }
    }

    @Override
    public void uncorrelationRoles(Integer userId, List<Integer> roleIds){
        QueryWrapper qw = new QueryWrapper();
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        for (Integer roleId:roleIds) {
            userRole.setRoleId(roleId);
            qw.setEntity(userRole);
            userRoleMapper.delete(qw);
        }
    }

    @Override
    public List<User> findByUserName(String name) {
        Map<String, Object> columnMap = new HashMap<String, Object>();
        columnMap.put("username", name);
        List<User> users= userMapper.selectByMap(columnMap);
        return users;
    }

    @Override
    public List<Role> findRoles(String username) {
        User user = null;
        List<User> userList = findByUserName(username);
        if(userList.size()!=0){
            user = userList.get(0);
        }
        List<Role> roles = roleService.findByUserId(user.getId());
        return roles;
    }

    @Override
    public List<Permission> findPermissions(String username) {
        List<Role> roles = findRoles(username);
        List<Permission> permissions = permissionService.findByRoles(roles);
        return permissions;
    }
}
