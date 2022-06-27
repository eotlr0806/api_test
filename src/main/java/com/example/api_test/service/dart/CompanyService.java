package com.example.api_test.service.dart;

import com.example.api_test.dto.common.Response;
import com.example.api_test.dto.common.ResponseCode;
import com.example.api_test.dto.dart.Uri;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CompanyService {

    private RestTemplate restTemplate;
    public CompanyService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Response getCompanyApi(String userKey, String companyCode){

        String uri = getCompanyUri(userKey, companyCode);
        if(!StringUtils.hasText(uri)){
            return new Response(ResponseCode.FAIL);
        }

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                uri,
                String.class
        );
        log.info("[CompanyService][getCompanyApi] response: {}", responseEntity.getBody());

        return new Response(ResponseCode.FAIL);
    }

    private String getCompanyUri(String userKey, String companyCode){
        if(StringUtils.hasText(userKey) && StringUtils.hasText(companyCode)){
            return Uri.COMPANY.getUri() + "?crtfc_key=" + userKey + "&corp_code=" + companyCode;
        }
        return null;
    }

}
