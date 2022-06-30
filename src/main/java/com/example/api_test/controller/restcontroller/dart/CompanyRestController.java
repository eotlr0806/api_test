package com.example.api_test.controller.restcontroller.dart;

import com.example.api_test.dto.common.Response;
import com.example.api_test.dto.common.ResponseCode;
import com.example.api_test.service.dart.CompanyService;
import com.example.api_test.service.dart.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class CompanyRestController {

    final private UserService userService;
    final private CompanyService companyService;
    public CompanyRestController(UserService userService, CompanyService companyService){
        this.userService = userService;
        this.companyService = companyService;
    }

    @GetMapping("/company/list")
    public Response getCompany(@RequestParam String company_code,
                               HttpServletRequest request){

        String userKey = userService.getUserKey(request);
        if(!StringUtils.hasText(userKey)){
            log.error("[CompanyRestController][getCompany] Session is null");
            return Response.create(ResponseCode.NO_SESSION);
        }
        return companyService.getCompanyApi(userKey, company_code);
    }

}
