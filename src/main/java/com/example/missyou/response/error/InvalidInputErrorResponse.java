package com.example.missyou.response.error;

import java.io.Serializable;
import java.util.Map;

public class InvalidInputErrorResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    public String message;
    public Integer statusCode;
    public Map<String,String> errors;
    public InvalidInputErrorResponse(String error, Integer statusCode, Map<String,String> errors) {
        this.message = error;
        this.statusCode = statusCode;
        this.errors = errors;
    }
}
