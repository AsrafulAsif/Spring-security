package com.example.missyou.exeptionandler;

import com.example.missyou.dto.error.InvalidInputErrorResponseREST;
import com.example.missyou.response.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public InvalidInputErrorResponseREST handleRequestParameterException(MethodArgumentNotValidException e) {
        String message = "Invalid inputs";
        Integer statusCode = HttpStatus.BAD_REQUEST.value();

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new InvalidInputErrorResponseREST(message, statusCode,errors);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public SimpleErrorResponse handleBadRequestException(Exception e) {
        return new SimpleErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }


}
