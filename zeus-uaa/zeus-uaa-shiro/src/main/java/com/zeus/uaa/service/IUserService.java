package com.zeus.uaa.service;

import com.zeus.uaa.entity.Permission;
import com.zeus.uaa.entity.Role;
import com.zeus.uaa.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyz
 * @since 2020-04-24
 */
public interface IUserService extends IService<User> {
    //创建账户
    public User createUser(User user);
    //修改密码
    public void changePassword(Integer userId, String newPassword);
    //添加用户-角色关系
    public void correlationRoles(Integer userId, List<Integer> roleIdList);
    //移除用户-角色关系
    public void uncorrelationRoles(Integer userId, List<Integer> roleIdList);
    //根据用户名查找用户
    public List<User> findByUserName(String name);
    //根据用户名查找其角色
    public List<Role> findRoles(String username);
    //根据用户名查找其权限
    public List<Permission> findPermissions(String username);
}
