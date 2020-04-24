package com.zeus.uaa.common.model.vo;

import com.zeus.uaa.common.constant.enums.ResponseEnums;

import java.io.Serializable;

/**
 * 返回结果统一封装
 */
public class RespBean<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public static <T> RespBean<T> build() {
        return new RespBean<>();
    }

    public static <T> RespBean<T> ok(String msg) {
        return new RespBean<>(2000, msg, null);
    }

    public static <T> RespBean<T> ok(String msg, T obj) {
        return new RespBean<>(2000, msg, obj);
    }

    public static <T> RespBean<T> error(String msg) {
        return new RespBean<>(500, msg, null);
    }

    public static <T> RespBean<T> error(Integer status, String msg) {
        return new RespBean<>(status, msg, null);
    }

    public static <T> RespBean<T> error(String msg, T obj) {
        return new RespBean<>(500, msg, obj);
    }

    public RespBean() {
    }

    public RespBean(ResponseEnums res) {
        this.code = res.getCode();
        this.msg = res.getMsg();
    }
    public RespBean(ResponseEnums res,T obj) {
        this.code = res.getCode();
        this.msg = res.getMsg();
        this.data = obj;
    }
    public RespBean(Integer code, String msg, T obj) {
        this.code = code;
        this.msg = msg;
        this.data = obj;
    }

    public Integer getCode() {
        return code;
    }

    public RespBean<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespBean<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RespBean<T> setData(T obj) {
        this.data = obj;
        return this;
    }
}
