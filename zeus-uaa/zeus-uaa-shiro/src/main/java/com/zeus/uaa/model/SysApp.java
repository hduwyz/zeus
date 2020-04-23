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
public class SysApp implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private String name;

    private String appKey;

    private String appSecret;

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
    
    public String getAppKey() {
        return appKey;
    }

      public void setAppKey(String appKey) {
          this.appKey = appKey;
      }
    
    public String getAppSecret() {
        return appSecret;
    }

      public void setAppSecret(String appSecret) {
          this.appSecret = appSecret;
      }
    
    public Boolean getAvailable() {
        return available;
    }

      public void setAvailable(Boolean available) {
          this.available = available;
      }

    @Override
    public String toString() {
        return "SysApp{" +
              "id=" + id +
                  ", name=" + name +
                  ", appKey=" + appKey +
                  ", appSecret=" + appSecret +
                  ", available=" + available +
              "}";
    }
}
