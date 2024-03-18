package com.rosoa0475.hospital.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class controller {
    @GetMapping("/search")
    public Map<String, String> getMethodName(@RequestParam(name = "city") String city, @RequestParam(name = "township") String township) {
        
    }
    
}
