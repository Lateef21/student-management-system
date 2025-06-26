package com.lateef.studentManagementSystem.service;

import com.lateef.studentManagementSystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    private ArrayList<Student> students = null;

    public Student createStudent(Student student) {

        if(students == null){
            students = new ArrayList<>();
        }

        students.add(student);

        return student;
    }

    public ArrayList<Student> listStudents() {
        return students;
    }

    public boolean deleteStudent(String studentId) {
        return students.removeIf(student -> student.getStudentId().equals(studentId));
    }
}
