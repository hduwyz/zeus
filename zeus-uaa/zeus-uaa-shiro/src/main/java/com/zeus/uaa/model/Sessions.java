package com.zeus.uaa.model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wyz
 * @since 2020-04-23
 */
public class Sessions implements Serializable {

    private static final long serialVersionUID=1L;

      private String id;

    private String session;

    
    public String getId() {
        return id;
    }

      public void setId(String id) {
          this.id = id;
      }
    
    public String getSession() {
        return session;
    }

      public void setSession(String session) {
          this.session = session;
      }

    @Override
    public String toString() {
        return "Sessions{" +
              "id=" + id +
                  ", session=" + session +
              "}";
    }
}
