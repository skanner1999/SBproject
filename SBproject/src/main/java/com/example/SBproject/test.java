package com.example.SBproject;

import org.springframework.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @GetMapping("/")
    public String greeting() {
        return "Hello Brandon";
    }
    
}
