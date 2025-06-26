package com.lateef.SudentManagementSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class Student {
    private String fullName;
    private String studentId;
    private int age;
    private String course;
    private ArrayList<Course> courses;

    public Student(String fullName, String studentId, int age, String course) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.age = age;
        this.course = course;
    }

    public Student() {
    }

}
