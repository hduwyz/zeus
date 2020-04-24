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
public class RolePermission implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 角色id
     */
        private Integer roleId;

      /**
     * 权限id
     */
      private Integer permissionId;

    
    public Integer getRoleId() {
        return roleId;
    }

      public void setRoleId(Integer roleId) {
          this.roleId = roleId;
      }
    
    public Integer getPermissionId() {
        return permissionId;
    }

      public void setPermissionId(Integer permissionId) {
          this.permissionId = permissionId;
      }

    @Override
    public String toString() {
        return "RolePermission{" +
              "roleId=" + roleId +
                  ", permissionId=" + permissionId +
              "}";
    }
}
