package com.zeus.uaa.mapper;

import com.zeus.uaa.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> findRolesByUserId(@Param("uid") Integer uid);

}
