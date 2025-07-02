package com.lateef.StudentManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Full name is required")
    @Column(nullable = false)
    private String fullName;

    @NotBlank(message = "Student Registration Number is required")
    @Column(nullable = false, unique = true)
    private String studentRegNo;

    @NotBlank(message = "Student ID is required")
    @Column(nullable = false, unique = true)
    private String studentId;

    @NotNull(message = "Age is required")
    @Min(value = 1, message = "Age must be at least 1")
    @Column(nullable = false)
    private int age;

    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<CourseEntity> courses = new ArrayList<>();


    public StudentEntity() {
        this.studentRegNo = "SMS-" + RandomStringUtils.secure().nextNumeric(8);
        this.studentId = RandomStringUtils.secure().nextNumeric(12);
    }

    public StudentEntity(String fullName, int age) {
        this();
        this.fullName = fullName;
        this.age = age;
    }


}

