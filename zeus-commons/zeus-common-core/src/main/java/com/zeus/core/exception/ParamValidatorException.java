package com.zeus.core.exception;

import com.zeus.core.enums.ErrorCode;

public class ParamValidatorException extends RuntimeException{

    //自定义异常码
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ParamValidatorException(ErrorCode error) {
        // 父类的构造函数；调用底层的Throwable的构造函数，将参数message赋值到detailMessage (Throwable的属性)
        super(error.getDesc());
        //赋值code码
        this.code = error.getCode();
    }

    public ParamValidatorException(String message, String code) {
        // 父类的构造函数；调用底层的Throwable的构造函数，将参数message赋值到detailMessage (Throwable的属性)
        super(message);
        //赋值code码
        this.code = code;
    }

    public ParamValidatorException(String message) {
        // 父类的构造函数；调用底层的Throwable的构造函数，将参数message赋值到detailMessage (Throwable的属性)
        super(message);
    }
}
