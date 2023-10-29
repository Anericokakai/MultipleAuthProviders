package com.security.multiple_authproviders.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
//! prefix

public class UserController {


  @PreAuthorize("hasAuthority('read')")

    @GetMapping("/home")
    public  String res(){
        return "hello there";
    }

//    if the path variable has a certain name that is on ou cntext

    @GetMapping("/home/{name}")
    @PreAuthorize("#name==authentication.name")
    public  String  res2(@PathVariable("name") String  name)
    {
        return  "hello there "+name;

    }

//    complex authorization mechanism

//    we create a class that will handle the method then use it directly in our preAuthiorize


    @GetMapping("/home/name/{name}")
    @PreAuthorize("@auhtorizeClient.condition(#name)")
    public  String  res3(@PathVariable("name") String name){
      return "hello there from res 3";
    }



}
