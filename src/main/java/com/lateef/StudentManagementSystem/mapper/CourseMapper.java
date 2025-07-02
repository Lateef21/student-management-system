package com.lateef.StudentManagementSystem.mapper;

import com.lateef.StudentManagementSystem.entity.CourseEntity;
import com.lateef.StudentManagementSystem.model.Course;

public class CourseMapper {

    public static CourseEntity toEntity(Course model) {
        CourseEntity entity = new CourseEntity();
        entity.setName(model.getName());
        entity.setCode(model.getCode());
        entity.setUnit(model.getUnit());
        return entity;
    }

    public static Course toModel(CourseEntity entity) {
        Course model = new Course();
        model.setName(entity.getName());
        model.setCode(entity.getCode());
        model.setUnit(entity.getUnit());
        return model;
    }
}

