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
public class SysRole implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private String role;

    private String description;

    private String resourceIds;

    private Boolean available;

    
    public Long getId() {
        return id;
    }

      public void setId(Long id) {
          this.id = id;
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
    
    public String getResourceIds() {
        return resourceIds;
    }

      public void setResourceIds(String resourceIds) {
          this.resourceIds = resourceIds;
      }
    
    public Boolean getAvailable() {
        return available;
    }

      public void setAvailable(Boolean available) {
          this.available = available;
      }

    @Override
    public String toString() {
        return "SysRole{" +
              "id=" + id +
                  ", role=" + role +
                  ", description=" + description +
                  ", resourceIds=" + resourceIds +
                  ", available=" + available +
              "}";
    }
}
