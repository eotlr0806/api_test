package com.example.api_test.dto.common;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS(2000,"성공했습니다."),
    FAIL(3000, "실패했습니다."),
    PARSE_FAIL(4000, "파싱에러가 발생했습니다");

    private Integer code;
    private String msg;

}
