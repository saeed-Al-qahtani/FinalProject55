package com.example.finalproject.Advise;

import com.example.finalproject.DTO.ApiResponse;
import com.example.finalproject.Exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity apiException(ApiException apiException){
        return ResponseEntity.status(400).body(new ApiResponse(apiException.getMessage(),400));
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity data(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message,400));
    }
}