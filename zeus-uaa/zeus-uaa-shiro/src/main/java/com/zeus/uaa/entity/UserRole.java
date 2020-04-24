package com.zeus.uaa.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wyz
 * @since 2020-04-24
 */
public class UserRole implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 用户id
     */
        private Integer userId;

      /**
     * 角色id
     */
      private Integer roleId;

    
    public Integer getUserId() {
        return userId;
    }

      public void setUserId(Integer userId) {
          this.userId = userId;
      }
    
    public Integer getRoleId() {
        return roleId;
    }

      public void setRoleId(Integer roleId) {
          this.roleId = roleId;
      }

    @Override
    public String toString() {
        return "UserRole{" +
              "userId=" + userId +
                  ", roleId=" + roleId +
              "}";
    }
}
