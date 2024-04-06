package com.functionalprogramming.response;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class Response {

    public static Map<String, Object> generateResponse(Object body, String message) {

        Map<String, Object> response = new HashMap<>();
        response.put("body", body);
        response.put("message", message);
        return response;
    }
}