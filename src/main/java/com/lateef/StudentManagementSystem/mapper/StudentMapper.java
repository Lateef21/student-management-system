package com.lateef.StudentManagementSystem.mapper;

import com.lateef.StudentManagementSystem.entity.StudentEntity;
import com.lateef.StudentManagementSystem.model.Student;

public class StudentMapper {

    public static StudentEntity toEntity(Student model) {
        StudentEntity entity = new StudentEntity();
        entity.setFullName(model.getFullName());
        entity.setAge(model.getAge());
        entity.setStudentRegNo(model.getStudentRegNo());
        // courses can be mapped later if needed
        return entity;
    }

    public static Student toModel(StudentEntity entity) {
        Student model = new Student();
        model.setFullName(entity.getFullName());
        model.setAge(entity.getAge());
        model.setStudentRegNo(entity.getStudentRegNo());
        // studentId can be set as entity.getId().toString() if needed
        return model;
    }
}

