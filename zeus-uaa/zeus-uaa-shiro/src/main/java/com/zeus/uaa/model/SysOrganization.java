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
public class SysOrganization implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private String name;

    private Long parentId;

    private String parentIds;

    private Boolean available;

    
    public Long getId() {
        return id;
    }

      public void setId(Long id) {
          this.id = id;
      }
    
    public String getName() {
        return name;
    }

      public void setName(String name) {
          this.name = name;
      }
    
    public Long getParentId() {
        return parentId;
    }

      public void setParentId(Long parentId) {
          this.parentId = parentId;
      }
    
    public String getParentIds() {
        return parentIds;
    }

      public void setParentIds(String parentIds) {
          this.parentIds = parentIds;
      }
    
    public Boolean getAvailable() {
        return available;
    }

      public void setAvailable(Boolean available) {
          this.available = available;
      }

    @Override
    public String toString() {
        return "SysOrganization{" +
              "id=" + id +
                  ", name=" + name +
                  ", parentId=" + parentId +
                  ", parentIds=" + parentIds +
                  ", available=" + available +
              "}";
    }
}
