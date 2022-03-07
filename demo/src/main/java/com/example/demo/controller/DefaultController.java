package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RequestMapping("/")
@Controller
public class DefaultController {

    @RequestMapping
    public ResponseEntity<Map<String, Object>> forwardRequest(final HttpServletRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Refirecting failed. Path does not exists.");
        body.put("request", request.getRequestURL().toString());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
