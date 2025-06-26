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

    public Student updateStudent(String studentId, Student updatedStudent) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                student.setFullName(updatedStudent.getFullName());
                student.setAge(updatedStudent.getAge());
                student.setCourse(updatedStudent.getCourse());
                return student;
            }
        }
        return null; // Or throw exception
    }

}
