package com.zeus.security.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class IpAuthenticationToken extends AbstractAuthenticationToken {

    private String ip;

    public IpAuthenticationToken(String ip) {
        super(null);
        this.ip = ip;
        super.setAuthenticated(false);//注意这个构造方法是认证时使用的
    }

    public IpAuthenticationToken(String ip, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.ip = ip;
        super.setAuthenticated(true);//注意这个构造方法是认证成功后使用的

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.ip;
    }
}
