package com.zeus.uaa.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wyz
 * @since 2020-04-23
 */
public class SysUser implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long organizationId;

    private String username;

    private String password;

    private String salt;

    private Boolean locked;

    
    public Long getId() {
        return id;
    }

      public void setId(Long id) {
          this.id = id;
      }
    
    public Long getOrganizationId() {
        return organizationId;
    }

      public void setOrganizationId(Long organizationId) {
          this.organizationId = organizationId;
      }
    
    public String getUsername() {
        return username;
    }

      public void setUsername(String username) {
          this.username = username;
      }
    
    public String getPassword() {
        return password;
    }

      public void setPassword(String password) {
          this.password = password;
      }
    
    public String getSalt() {
        return salt;
    }

      public void setSalt(String salt) {
          this.salt = salt;
      }
    
    public Boolean getLocked() {
        return locked;
    }

      public void setLocked(Boolean locked) {
          this.locked = locked;
      }

    @Override
    public String toString() {
        return "SysUser{" +
              "id=" + id +
                  ", organizationId=" + organizationId +
                  ", username=" + username +
                  ", password=" + password +
                  ", salt=" + salt +
                  ", locked=" + locked +
              "}";
    }
}
