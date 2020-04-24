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
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 主键
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 资源路径 如：/userinfo/list
     */
      private String url;

      /**
     * 权限字符串：anon、logout、authc
     */
      private String permission;

      /**
     * 权限排序
     */
      private Integer sort;

      /**
     * 权限描述
     */
      private String description;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public String getUrl() {
        return url;
    }

      public void setUrl(String url) {
          this.url = url;
      }
    
    public String getPermission() {
        return permission;
    }

      public void setPermission(String permission) {
          this.permission = permission;
      }
    
    public Integer getSort() {
        return sort;
    }

      public void setSort(Integer sort) {
          this.sort = sort;
      }
    
    public String getDescription() {
        return description;
    }

      public void setDescription(String description) {
          this.description = description;
      }

    @Override
    public String toString() {
        return "Permission{" +
              "id=" + id +
                  ", url=" + url +
                  ", permission=" + permission +
                  ", sort=" + sort +
                  ", description=" + description +
              "}";
    }
}
