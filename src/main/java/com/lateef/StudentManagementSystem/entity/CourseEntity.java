package com.lateef.StudentManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "courses")
@Getter
@Setter
@ToString
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Course name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Course code is required")
    @Column(nullable = false, unique = true)
    private String code;

    @NotNull(message = "Unit is required")
    @Min(value = 1, message = "Cannot be less than 1 Unit")
    @Column(nullable = false)
    private int unit;

    @ManyToMany(mappedBy = "courses")
    private List<StudentEntity> students = new ArrayList<>();
}
