package com.example.api_test.dto.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Response<T> {

    private Integer code;
    private String msg;
    private T data;

    private Response(){}
    public Response(ResponseCode responseCode, T data){
        this.code = responseCode.getCode();
        this.msg  = responseCode.getMsg();
        this.data = data;
    }
    public Response(ResponseCode responseCode){
        this.code = responseCode.getCode();
        this.msg  = responseCode.getMsg();
    }


}
