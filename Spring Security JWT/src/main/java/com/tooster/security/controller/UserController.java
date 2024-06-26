package com.tooster.security.controller;

import com.tooster.security.dto.LoginRequest;
import com.tooster.security.model.UserInfo;
import com.tooster.security.service.JwtService;
import com.tooster.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return userService.authenticate(loginRequest);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserInfo userInfo){
        System.out.println("test");
        return userService.addUser(userInfo);
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Talha";
    }

}
