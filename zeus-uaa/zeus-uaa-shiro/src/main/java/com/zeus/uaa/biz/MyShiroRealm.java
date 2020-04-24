package com.zeus.uaa.biz;

import com.zeus.uaa.entity.Permission;
import com.zeus.uaa.entity.Role;
import com.zeus.uaa.entity.User;
import com.zeus.uaa.service.IPermissionService;
import com.zeus.uaa.service.IRoleService;
import com.zeus.uaa.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  身份校验核心类;
 *  自定义一个Realm类，继承AuthorizingRealm抽象类，重载doGetAuthenticationInfo()，重写获取用户信息的方法。
 *
 * @author
 * @version
 */
public class MyShiroRealm extends AuthorizingRealm {


    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    /**
     * 认证信息.(身份验证)
     * :
     * Authentication 是用来验证用户身份
     * 1、检查提交的进行认证的令牌信息
     * 2、根据令牌信息从数据源(通常为数据库)中获取用户信息
     * 3、对用户信息进行匹配验证。
     * 4、验证通过将返回一个封装了用户信息的AuthenticationInfo实例。
     * 5、验证失败则抛出AuthenticationException异常信息。
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");

        //获取用户的输入的账号.
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        String username = usernamePasswordToken.getUsername();

        //通过username从数据库中查找 User对象
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        List<User> userList = userService.findByUserName(username);
        User user = null;
        String salt = null;
        if(userList.size()!=0){
            user = userList.get(0);
            salt = user.getSalt();
        }
        if(user == null){
            throw new AccountException("帐号或密码不正确！");
        }
        else if(user.getState().equals("1")){
            /**
             * 如果用户的status为禁用。那么就抛出DisabledAccountException
             */
            throw new DisabledAccountException("帐号已经禁止登录！");
        }
        else{
            //更新登录时间 last login time
            user.setLastLoginTime( new Date());
            userService.updateById(user);
        }


        //账号判断;
        //明文方式: 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                //用户名
                user,
                //密码
                user.getPassword(),
                //realm name
                getName()
                );
        //加密方式;
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username + salt));
        return authenticationInfo;
    }



    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     *
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*
         * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
         * 但其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
         * 当放到缓存中时，doGetAuthorizationInfo就只会执行一次了，
         * 缓存过期之后会再次执行。
         * 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
         */
        System.out.println("权限认证方法：MyShiroRealm.doGetAuthorizationInfo()");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //System.out.println(principals.getPrimaryPrincipal().toString());
        User user  = (User) principals.getPrimaryPrincipal();
        Integer userId = user.getId();
        //获取角色并添加
        List<Role> roleList = roleService.findByUserId(userId);
        Set<String> roleSet = new HashSet<String>();
        for(Role role : roleList){
            roleSet.add(role.getRole());
        }
        authorizationInfo.setRoles(roleSet);
        //获取权限并添加
        List<Permission> permissionList = permissionService.findByRoles(roleList);
        Set<String> permissionSet = new HashSet<String>();
        for(Permission permission : permissionList){
            String perms = permission.getPermission().toString();
            perms = perms.substring(perms.indexOf("[")+1,perms.indexOf("]"));
            permissionSet.add(perms);
        }
        //permissionSet.add("config");
        authorizationInfo.setStringPermissions(permissionSet);

        //权限单个添加;
        //或者按下面这样添加
        //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
//     authorizationInfo.addRole("admin");
        //添加权限
//     authorizationInfo.addStringPermission("userInfo:query");

        return authorizationInfo;
    }

}