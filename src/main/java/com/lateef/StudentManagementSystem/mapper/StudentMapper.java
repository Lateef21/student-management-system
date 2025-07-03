package com.lateef.StudentManagementSystem.mapper;

import com.lateef.StudentManagementSystem.entity.CourseEntity;
import com.lateef.StudentManagementSystem.entity.StudentEntity;
import com.lateef.StudentManagementSystem.model.Course;
import com.lateef.StudentManagementSystem.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {

    public static StudentEntity toEntity(Student model) {
        StudentEntity entity = new StudentEntity();
        entity.setFullName(model.getFullName());
        entity.setAge(model.getAge());
        entity.setStudentRegNo(model.getStudentRegNo());
        return entity;
    }

    public static Student toModel(StudentEntity entity) {
        Student model = new Student();
        model.setFullName(entity.getFullName());
        model.setAge(entity.getAge());
        model.setStudentRegNo(entity.getStudentRegNo());
        model.setStudentId(entity.getStudentId());

        if (entity.getCourses() != null && !entity.getCourses().isEmpty()) {

            List<CourseEntity> courseEntities = entity.getCourses();

            ArrayList<Course> courses = new ArrayList<>();

            for(CourseEntity courseEntity: courseEntities) {
                courseEntity.setStudents(null);
                Course course = CourseMapper.toModel(courseEntity);

                courses.add(course);
            }

            model.setCourses(courses);

//            model.setCourses(
//                    entity.getCourses()
//                            .stream()
//                            .map(CourseMapper::toModel)
//                            .collect(Collectors.toCollection(java.util.ArrayList::new))
//            );
        }
        return model;
    }
}

