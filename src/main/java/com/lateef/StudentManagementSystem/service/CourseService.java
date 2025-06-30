package com.lateef.StudentManagementSystem.service;

import com.lateef.StudentManagementSystem.entity.CourseEntity;
import com.lateef.StudentManagementSystem.mapper.CourseMapper;
import com.lateef.StudentManagementSystem.model.Course;
import com.lateef.StudentManagementSystem.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private ArrayList<Course> courses = new ArrayList<>();

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        CourseEntity entity = CourseMapper.toEntity(course);
        entity = courseRepository.save(entity);
        course = CourseMapper.toModel(entity);
        return course;
    }

    public ArrayList<Course> listCourses() {
        return new ArrayList<>(courses);
    }

    public boolean deleteCourse(String code) {
        return courses.removeIf(course -> course.getCode().equalsIgnoreCase(code));
    }

    public Course updateCourse(String code, Course updatedCourse) {
        for (Course course : courses) {
            if (course.getCode().equalsIgnoreCase(code)) {
                course.setName(updatedCourse.getName());
                course.setCode(updatedCourse.getCode());
                return course;
            }
        }
        return null;
    }


}
