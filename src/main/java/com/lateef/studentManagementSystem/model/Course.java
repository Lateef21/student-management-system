package com.lateef.studentManagementSystem.model;

import java.util.ArrayList;

public class Course {
    private String name;
    private String courseId;
    private int unit;
    private String code;
    private ArrayList<Student> students;

    public Course(String name, String courseId, int unit, String code) {
        this.name = name;
        this.courseId = courseId;
        this.unit = unit;
        this.code = code;
    }

    public Course() {
    }

    public String getCode() {
        return code;
    }

}
