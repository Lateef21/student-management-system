package com.lateef.studentManagementSystem.controller;

import com.lateef.studentManagementSystem.model.Course;
import com.lateef.studentManagementSystem.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping
@RestController("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course result = courseService.createCourse(course);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Course>> listCourses() {
        ArrayList<Course> result = courseService.listCourses();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteCourse(@PathVariable String code) {
        boolean deleted = courseService.deleteCourse(code);
        if (deleted) {
            return ResponseEntity.ok("Course deleted successfully.");
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

}

