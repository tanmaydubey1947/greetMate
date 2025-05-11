package com.greetmate.controller;


import com.greetmate.model.GreetMateRequest;
import com.greetmate.model.GreetMateResponse;
import com.greetmate.service.GreetMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GreetMateController {

    @Autowired
    private GreetMateService service;

    @PostMapping
    public ResponseEntity<?> addFriendBirthday(@RequestBody GreetMateRequest request) {
        GreetMateResponse greetMateResponse = service.addFriendBirthday(request);
        return ResponseEntity.ok(greetMateResponse);
    }
}
