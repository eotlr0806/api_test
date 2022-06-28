package com.example.api_test.service.dart;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * User 정보 관리 Service
 */
@Service
public class UserService {

    public void saveDartKey(String key, HttpServletRequest request){
        request.getSession().setAttribute("key", key);
    }

    public String getUserKey(HttpServletRequest request){
        Object key = request.getSession().getAttribute("key");
        if(ObjectUtils.isEmpty(key)){
            return null;
        }
        return String.valueOf(key);
    }
}
