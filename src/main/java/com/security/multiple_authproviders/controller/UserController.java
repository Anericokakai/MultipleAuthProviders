package com.security.multiple_authproviders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//! prefix
@RequestMapping("/users")
public class UserController {
    @GetMapping("/api")
    public  String res(){
        return "hello there";
    }
    @GetMapping("/home")
    public  String  res2(){
        return  "hello from home";

    }
    @PostMapping("/new")
    public  String  res3(){
        return  "hello from home";

    }
    @GetMapping ("/new")
    public  String  res4(){
        return  "hello from home";

    }
}
