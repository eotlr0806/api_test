package com.example.api_test.config;

import com.example.api_test.dto.common.Response;
import com.example.api_test.dto.common.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdviceConfig {

    @ExceptionHandler(Exception.class)
    public Response<ResponseCode> commonResponseExceptionHandler(Exception e){
        log.error("[ControllerAdviceConfig] error : {}", e.getMessage());
        return Response.create(ResponseCode.FAIL);
    }
}
