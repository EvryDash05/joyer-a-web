package com.example.joyeria.exceptions.custom;

public class BusinessException extends RuntimeException{

    private final int code;

    public BusinessException(final int code, final String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
