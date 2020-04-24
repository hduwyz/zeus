package com.zeus.uaa.service;

import com.zeus.uaa.entity.Role;
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
public interface IRoleService extends IService<Role> {
    public List<Role> findByUserId(Integer uid);
    //添加角色-权限之间关系
    public void correlationPermissions(Integer roleId, List<Integer> permissionIdList);
    //移除角色-权限之间关系
    public void uncorrelationPermissions(Integer roleId, List<Integer> permissionIdList);

}
