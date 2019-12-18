package com.example.hello.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloBean(){
        return new HelloWorldBean("Bonjour toute le monde!");
    }
}
