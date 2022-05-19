package com.comento.practical.exception;

import com.comento.practical.dto.PracticalErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.comento.practical.exception.PracticalErrorCode.INTERNAL_SERVER_ERROR;
import static com.comento.practical.exception.PracticalErrorCode.INVALID_REQUEST;

@Slf4j
@RestControllerAdvice
public class PracticalExceptionHandler {

    @ExceptionHandler(PracticalException.class)
    public PracticalErrorResponse handleException(PracticalException e, HttpServletRequest request){
        log.error("errorCode : {}, url : {}, message : {}",
                e.getPracticalErrorCode(),request.getRequestURL(), e.getDetailMessage());
        return PracticalErrorResponse.builder()
                .errorCode(e.getPracticalErrorCode())
                .errorMessage(e.getDetailMessage())
                .build();
    }

    @ExceptionHandler(value = {
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class
    })
    public PracticalErrorResponse handleBadRequest(Exception e,HttpServletRequest request){
        log.error("url : {}, message : {}",
                request.getRequestURL(), e.getMessage());
        return PracticalErrorResponse.builder()
                .errorCode(INVALID_REQUEST)
                .errorMessage(INVALID_REQUEST.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public PracticalErrorResponse handleException(Exception e, HttpServletRequest request){
        log.error("url : {}, message : {}",
                request.getRequestURL(), e.getMessage());

        return PracticalErrorResponse.builder()
                .errorCode(INTERNAL_SERVER_ERROR)
                .errorMessage(INTERNAL_SERVER_ERROR.getMessage())
                .build();

    }



}
