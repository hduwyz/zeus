package com.zeus.uaa.mapper;

import com.zeus.uaa.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeus.uaa.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyz
 * @since 2020-04-24
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> findPermissionsByRoles(@Param("roles") List<Role> roles);
}
