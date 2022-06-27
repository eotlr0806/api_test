package com.example.api_test.controller.restcontroller.dart;

import com.example.api_test.dto.common.Response;
import com.example.api_test.dto.common.ResponseCode;
import com.example.api_test.dto.dart.User;
import com.example.api_test.service.dart.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UploadRestController {

    final private UserService userService;
    public UploadRestController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/upload/key")
    public Response uploadKey(@RequestBody User user,
                            HttpServletRequest request){

        if(!ObjectUtils.isEmpty(user) && StringUtils.hasText(user.getKey())){
            userService.saveDartKey(user.getKey(), request);
            return new Response(ResponseCode.SUCCESS);
        }else{
            return new Response(ResponseCode.FAIL);
        }
    }
}
