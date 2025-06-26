package com.lateef.studentManagementSystem.controller;

import com.lateef.studentManagementSystem.model.Student;
import com.lateef.studentManagementSystem.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student result = studentService.createStudent(student);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Student>> listStudents() {
        ArrayList<Student> result = studentService.listStudents();
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStudent(@PathVariable("id") String studentId) {
        boolean deleted = studentService.deleteStudent(studentId);
        if (deleted) {
            return ResponseEntity.ok(" A Student has been deleted");
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

}
