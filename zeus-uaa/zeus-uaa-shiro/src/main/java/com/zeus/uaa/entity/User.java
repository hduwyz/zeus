package com.zeus.uaa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
public class User implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户名
     */
      private String username;

      /**
     * 登录密码
     */
      private String password;

      /**
     * 用户真实姓名
     */
      private String name;

      /**
     * 密码盐
     */
      private String salt;

      /**
     * 用户手机号
     */
      private String phoneNum;

      /**
     * 用户身份证号
     */
      private String idCardNum;

      /**
     * 创建时间
     */
      private Date createTime;

      /**
     * 最后登入时间
     */
      private Date lastLoginTime;

      /**
     * 用户状态：0:正常状态,1：用户被锁定
     */
      private String state;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
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
    
    public String getName() {
        return name;
    }

      public void setName(String name) {
          this.name = name;
      }
    
    public String getSalt() {
        return salt;
    }

      public void setSalt(String salt) {
          this.salt = salt;
      }
    
    public String getPhoneNum() {
        return phoneNum;
    }

      public void setPhoneNum(String phoneNum) {
          this.phoneNum = phoneNum;
      }
    
    public String getIdCardNum() {
        return idCardNum;
    }

      public void setIdCardNum(String idCardNum) {
          this.idCardNum = idCardNum;
      }
    
    public Date getCreateTime() {
        return createTime;
    }

      public void setCreateTime(Date createTime) {
          this.createTime = createTime;
      }
    
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

      public void setLastLoginTime(Date lastLoginTime) {
          this.lastLoginTime = lastLoginTime;
      }
    
    public String getState() {
        return state;
    }

      public void setState(String state) {
          this.state = state;
      }

    @Override
    public String toString() {
        return "User{" +
              "id=" + id +
                  ", username=" + username +
                  ", password=" + password +
                  ", name=" + name +
                  ", salt=" + salt +
                  ", phoneNum=" + phoneNum +
                  ", idCardNum=" + idCardNum +
                  ", createTime=" + createTime +
                  ", lastLoginTime=" + lastLoginTime +
                  ", state=" + state +
              "}";
    }
}
