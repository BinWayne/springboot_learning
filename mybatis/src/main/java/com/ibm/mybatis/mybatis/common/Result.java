package com.ibm.mybatis.mybatis.common;

public class Result<T> {
    private int code;
    private String message;
    private T result;

    public Result(Code code, T result) {
        this.code = code.getCode();
        this.message = code.getDesc();
        this.result = result;
    }
}
