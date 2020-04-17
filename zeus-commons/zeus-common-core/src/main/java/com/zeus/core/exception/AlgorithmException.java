package com.zeus.core.exception;

import com.zeus.core.enums.ErrorCode;

public class AlgorithmException extends RuntimeException{

    private static final long serialVersionUID = -8716100844379461082L;
    //自定义异常码
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AlgorithmException(ErrorCode error) {
        // 父类的构造函数；调用底层的Throwable的构造函数，将参数message赋值到detailMessage (Throwable的属性)
        super(error.getDesc());
        //赋值code码
        this.code = error.getCode();
    }

    public AlgorithmException(String message, String code) {
        // 父类的构造函数；调用底层的Throwable的构造函数，将参数message赋值到detailMessage (Throwable的属性)
        super(message);
        //赋值code码
        this.code = code;
    }

    public AlgorithmException(String message) {
        // 父类的构造函数；调用底层的Throwable的构造函数，将参数message赋值到detailMessage (Throwable的属性)
        super(message);
    }
}
