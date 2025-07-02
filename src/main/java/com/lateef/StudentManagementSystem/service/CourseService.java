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

    public List<Course> listCourses() {
        List<CourseEntity> entities = courseRepository.findAll();
        List<Course> courses = new ArrayList<>();
        for (CourseEntity entity : entities) {
            courses.add(CourseMapper.toModel(entity));
        }
        return courses;
    }

    public boolean deleteCourse(String code) {
        CourseEntity entity = courseRepository.findByCodeIgnoreCase(code);
        if (entity != null) {
            courseRepository.delete(entity);
            return true;
        }
        return false;
    }

    public Course updateCourse(String code, Course updatedCourse) {
        CourseEntity existingEntity = courseRepository.findByCodeIgnoreCase(code);
        if (existingEntity != null) {
            existingEntity.setName(updatedCourse.getName());
            existingEntity.setCode(updatedCourse.getCode());
            CourseEntity savedEntity = courseRepository.save(existingEntity);
            return CourseMapper.toModel(savedEntity);
        }
        return null;
    }
}
