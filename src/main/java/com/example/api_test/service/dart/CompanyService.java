package com.example.api_test.service.dart;

import com.example.api_test.dto.common.Response;
import com.example.api_test.dto.common.ResponseCode;
import com.example.api_test.dto.code.Uri;
import com.example.api_test.dto.dart.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
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

        ResponseEntity<Company> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                getEntity(),
                Company.class
        );
        log.info("[CompanyService][getCompanyApi] response: {}", responseEntity.getBody());
        return new Response(ResponseCode.SUCCESS, responseEntity.getBody());
    }

    private String getCompanyUri(String userKey, String companyCode){
        if(StringUtils.hasText(userKey) && StringUtils.hasText(companyCode)){
            return Uri.COMPANY.getUri() + "?crtfc_key=" + userKey + "&corp_code=" + companyCode;
        }
        return null;
    }

    private HttpEntity getEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity(headers);
    }

}
