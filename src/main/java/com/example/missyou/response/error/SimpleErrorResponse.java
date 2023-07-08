package com.example.missyou.response.error;

public class SimpleErrorResponse {
    public Integer status;
    public String message;

    public SimpleErrorResponse(String error, Integer status) {
        this.message = error;
        this.status=status;
    }
}
