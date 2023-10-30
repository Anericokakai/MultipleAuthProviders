package com.security.multiple_authproviders.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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



/*
? post authorize
? we can use it to check if the return value is wht we ented or the data from
? db is the actual value that we need
 */
//  todo example of post auhtorize

  @PostAuthorize("returnObject=='anerico'")
  @GetMapping("/home2")
  public  String  res4(){
    System.out.println("method executes first before condition");
    return  "anerico";
  }


/*
?   pre filter is used to filter the incomming data
? example we can check if the incoming request contains certain characters

*/
@PreFilter("filterObject.contains('b')")
@PostMapping("/home3")
  public  String  res5(@RequestBody List<String> values){
    System.out.println("values "+ values);
    return  "hello number 5";
  }

}
