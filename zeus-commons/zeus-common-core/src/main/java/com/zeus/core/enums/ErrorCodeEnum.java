package com.zeus.core.enums;

import lombok.Getter;

/**
 * 异常错误码枚举
 */
public enum ErrorCodeEnum implements ErrorCode{
    //100-500开头的为系统保留开头，其他为业务开头，总的错误码长度为7位长度
    //系统异常错误以100开头
    SYSTEM_ERROR("1000001", "系统内部错误"),

    //用户异常错误以600开头
    USERNAME_ERROR("6000001", "用户名错误"),
    PASSWORD_ERROR("6000002", "密码错误"),
    ;

    @Getter
    private String code;

    @Getter
    private String desc;

    ErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
