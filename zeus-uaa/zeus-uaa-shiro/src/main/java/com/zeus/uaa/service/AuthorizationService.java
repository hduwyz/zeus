package com.zeus.uaa.service;


import com.zeus.uaa.dao.entity.Authorization;

import java.util.List;
import java.util.Set;

public interface AuthorizationService {


    Authorization createAuthorization(Authorization authorization);
    Authorization updateAuthorization(Authorization authorization);
    void deleteAuthorization(Long authorizationId);

    Authorization findOne(Long authorizationId);
    List<Authorization> findAll();

    /**
     * 根据AppKey和用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String appKey, String username);

    /**
     * 根据AppKey和用户名查找权限字符串
     * @param username
     * @return
     */
    public Set<String> findPermissions(String appKey, String username);


}
