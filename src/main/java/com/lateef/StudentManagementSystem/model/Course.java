package com.lateef.StudentManagementSystem.model;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

public class Course {
    private String name;
    private final String courseId;
    private int unit;
    private String code;
    private ArrayList<Student> students;

    public Course(String name, int unit, String code) {
        this();
        this.name = name;
        this.unit = unit;
        this.code = code;
    }

    public Course() {
        this.courseId = RandomStringUtils.secureStrong().nextNumeric(5);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code; }

    public String getName() {
        return name; }

    public void setName(String name){
        this.name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
