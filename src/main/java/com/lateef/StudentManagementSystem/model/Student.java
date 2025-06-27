package com.lateef.StudentManagementSystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class Student {
    private String fullName;
    private String studentId;
    private String studentRegNo;
    private int age;
    private ArrayList<Course> courses;

    public Student(String fullName, int age) {
        super();
        this.fullName = fullName;
        this.age = age;
    }

    public Student() {
        this.studentRegNo = "SMS/" + RandomStringUtils.insecure().nextNumeric(6);
        this.studentId = RandomStringUtils.secure().nextNumeric(10);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentRegNo() {
        return studentRegNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
