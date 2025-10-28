package com.brainwired.brainwired.exception;


import com.brainwired.brainwired.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleFileUpload(EmployeeNotFoundException ex, HttpServletRequest request){
        return buildErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST,request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, HttpServletRequest request) {
        return buildErrorResponse("Something went wrong. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR, request.getRequestURI());
    }

    private ResponseEntity<ErrorResponse>buildErrorResponse(String message,HttpStatus status,String path){
        ErrorResponse error=new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                message,
                path
        );
        return new ResponseEntity<>(error,status);

    }

}
