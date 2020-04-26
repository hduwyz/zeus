package com.zeus.uaa.common.filter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeus.core.constant.CommonConstant;
import com.zeus.uaa.entity.User;
import com.zeus.uaa.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private IUserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        QueryWrapper queryWrapper = new QueryWrapper();
        User sysUser = new User();
        sysUser.setUsername(username);
        queryWrapper.setEntity(sysUser);
        request.setAttribute(CommonConstant.CURRENT_USER, userService.getOne(queryWrapper));
        return true;
    }
}
