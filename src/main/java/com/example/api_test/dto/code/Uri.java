package com.example.api_test.dto.code;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Uri {
    COMPANY("https://opendart.fss.or.kr/api/company.json");

    String uri;
}
