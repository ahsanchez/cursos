package com.in28minutes.unittesting.unittesting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorlController {
    
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
