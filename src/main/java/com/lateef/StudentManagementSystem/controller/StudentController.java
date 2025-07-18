package com.lateef.StudentManagementSystem.controller;

import com.lateef.StudentManagementSystem.model.Student;
import com.lateef.StudentManagementSystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student result = studentService.createStudent(student);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Student>> listStudents() {
        ArrayList<Student> result = (ArrayList<Student>) studentService.listStudents();
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudent(@PathVariable("id") String studentId) {
        boolean deleted = studentService.deleteStudent(studentId);
        if (deleted) {
            return ResponseEntity.ok("Student deleted");
        } else {
            return ResponseEntity.status(404).body("Student not found.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") String id, @RequestBody Student updatedStudent) {
        Student result = studentService.updateStudent(id, updatedStudent);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(404).body("Student not found.");
        }
    }

    @PostMapping("/{id}/assign-courses")
    public ResponseEntity<?> assignCourses(
            @PathVariable("id") String studentId,
            @RequestBody List<String> courseCodes) {
        try {
            Student result = studentService.assignCourses(studentId, courseCodes);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/remove-courses")
    public ResponseEntity<?> removeCoursesFromStudent(
            @PathVariable("id") String studentId,
            @RequestBody List<String> courseCodes) {
        try {
            Student updatedStudent = studentService.removeCourses(studentId, courseCodes);
            return ResponseEntity.ok(updatedStudent);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
