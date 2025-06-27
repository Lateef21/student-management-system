package com.lateef.StudentManagementSystem.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

public class Course {

    @NotBlank(message = "Full name is required")
    private String name;
    private final String courseId;

    @NotNull(message = "Unit is required")
    @Min(value = 1, message = "Cannot be less than 1 Unit")
    private int unit;

    @NotBlank(message = "Course Code is Required")
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
