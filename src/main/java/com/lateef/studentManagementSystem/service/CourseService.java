package com.lateef.studentManagementSystem.service;

import com.lateef.studentManagementSystem.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final List<Course> courses = new ArrayList<Course>();

    public Course createCourse(Course course) {
        courses.add(course);
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
                // optional, if changing code
                return course;
            }
        }
        return null;
    }


}
