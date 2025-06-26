package com.lateef.studentManagementSystem.controller;

import com.lateef.studentManagementSystem.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @RequestMapping("/")
    public String index(){
        System.out.println("Welcome to My Application");
        return "Welcome to My Application";
    }
//
//    @RequestMapping("/")
//    public String student(){
//        System.out.println("Enter Student name" + student());
//        return student();
//    }

    public String course(){
        System.out.println("Enter Course name" + course());
        return course();
    }
}
