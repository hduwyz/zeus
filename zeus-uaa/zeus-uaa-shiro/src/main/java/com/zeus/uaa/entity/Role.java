package com.zeus.uaa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wyz
 * @since 2020-04-24
 */
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 主键
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 是否可用0可用  1不可用
     */
      private String available;

      /**
     * 角色标识程序中判断使用,如"admin"
     */
      private String role;

      /**
     * 角色描述,UI界面显示使用
     */
      private String description;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public String getAvailable() {
        return available;
    }

      public void setAvailable(String available) {
          this.available = available;
      }
    
    public String getRole() {
        return role;
    }

      public void setRole(String role) {
          this.role = role;
      }
    
    public String getDescription() {
        return description;
    }

      public void setDescription(String description) {
          this.description = description;
      }

    @Override
    public String toString() {
        return "Role{" +
              "id=" + id +
                  ", available=" + available +
                  ", role=" + role +
                  ", description=" + description +
              "}";
    }
}
