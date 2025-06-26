package com.lateef.SudentManagementSystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @RequestMapping("/")
    public String index(){
        System.out.println("Welcome to My Application");
        return "Welcome to My Application";
    }

    public String course(){
        System.out.println("Enter Course name" + course());
        return course();
    }
}
