package com.lateef.StudentManagementSystem.controller;

import com.lateef.StudentManagementSystem.model.Course;
import com.lateef.StudentManagementSystem.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/course")
public class CourseController {


    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) {
        Course result = courseService.createCourse(course);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Course>> listCourses() {
        ArrayList<Course> result = (ArrayList<Course>) courseService.listCourses();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteCourse(@PathVariable String code) {
        boolean deleted = courseService.deleteCourse(code);
        if (deleted) {
            return ResponseEntity.ok("Course deleted");
        } else {
            return ResponseEntity.status(404).body("Course not found.");
        }
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateCourse(@PathVariable String code, @RequestBody Course updatedCourse) {
        Course result = courseService.updateCourse(code, updatedCourse);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(404).body("Course not found.");
        }
    }

    @GetMapping("/{code}/students")
    public ResponseEntity<?> getStudentsForCourse(@PathVariable("code") String courseCode) {
        try {
            Course result = courseService.getCourseWithStudents(courseCode);
            return ResponseEntity.ok(result.getStudents());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


}

