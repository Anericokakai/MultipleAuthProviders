package com.security.multiple_authproviders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/api")
    public  String res(){
        return "hello there";
    }
    @GetMapping("/home")
    public  String  res2(){
        return  "hello from home";

    }
}
