package com.lateef.StudentManagementSystem.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class Student {
    @NotBlank(message = "Full name is required")
    private String fullName;

    private String studentId;

    private String studentRegNo;

    @NotNull(message = "Age is required")
    @Min(value = 1, message = "Age must be at least 1")
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
}
