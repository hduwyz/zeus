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
public class SysUserAppRoles implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long userId;

    private Long appId;

    private String roleIds;

    
    public Long getId() {
        return id;
    }

      public void setId(Long id) {
          this.id = id;
      }
    
    public Long getUserId() {
        return userId;
    }

      public void setUserId(Long userId) {
          this.userId = userId;
      }
    
    public Long getAppId() {
        return appId;
    }

      public void setAppId(Long appId) {
          this.appId = appId;
      }
    
    public String getRoleIds() {
        return roleIds;
    }

      public void setRoleIds(String roleIds) {
          this.roleIds = roleIds;
      }

    @Override
    public String toString() {
        return "SysUserAppRoles{" +
              "id=" + id +
                  ", userId=" + userId +
                  ", appId=" + appId +
                  ", roleIds=" + roleIds +
              "}";
    }
}
