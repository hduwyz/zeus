package com.zeus.uaa.common.filter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeus.uaa.common.constant.Constants;
import com.zeus.uaa.model.SysUser;
import com.zeus.uaa.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private ISysUserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        QueryWrapper queryWrapper = new QueryWrapper();
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        queryWrapper.setEntity(sysUser);
        request.setAttribute(Constants.CURRENT_USER, userService.getOne(queryWrapper));
        return true;
    }
}
