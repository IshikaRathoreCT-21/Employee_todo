package com.example.EmployeeTodo.ExceptionHandler;

import com.example.EmployeeTodo.Response.EmployeeResponse;

import com.example.EmployeeTodo.contants.ConstantMessage;
import com.example.EmployeeTodo.contants.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerApplication {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public EmployeeResponse handleInvalidArgument(Exception ex) {
        return new EmployeeResponse(StatusCode.INTERNAL_SERVER_ERROR, ConstantMessage.GLOBAL_ERROR);
    }
}