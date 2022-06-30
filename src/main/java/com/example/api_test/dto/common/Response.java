package com.example.api_test.dto.common;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Response<T> {

    private Integer code;
    private String msg;
    private T data;

    public static Response<ResponseCode> create(ResponseCode responseCode){
        return new Response<>(responseCode);
    }
    public static <T> Response<T> create(ResponseCode responseCode, T data){
        return new Response<>(responseCode, data);
    }

    // static 메서드에서 쓰기 쉽게 하기위해 만든 private 생성자
    private Response(){}
    private Response(ResponseCode responseCode, T data){
        this.code = responseCode.getCode();
        this.msg  = responseCode.getMsg();
        this.data = data;
    }
    private Response(ResponseCode responseCode){
        this.code = responseCode.getCode();
        this.msg  = responseCode.getMsg();
    }

}
