package com.lateef.StudentManagementSystem.service;

import com.lateef.StudentManagementSystem.entity.CourseEntity;
import com.lateef.StudentManagementSystem.entity.StudentEntity;
import com.lateef.StudentManagementSystem.mapper.StudentMapper;
import com.lateef.StudentManagementSystem.model.Student;
import com.lateef.StudentManagementSystem.repository.CourseRepository;
import com.lateef.StudentManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        // Create a new StudentEntity using the mapper
        StudentEntity entity = StudentMapper.toEntity(student);
        // studentRegNo will be auto-generated in the entity constructor if null
        if (entity.getStudentRegNo() == null || entity.getStudentRegNo().isBlank()) {
            entity.setStudentRegNo("SMS-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        entity = studentRepository.save(entity);
        return StudentMapper.toModel(entity);
    }

    public List<Student> listStudents() {
        List<StudentEntity> entities = studentRepository.findAll();
        List<Student> students = new ArrayList<>();
        for (StudentEntity entity : entities) {
            students.add(StudentMapper.toModel(entity));
        }
        return students;
    }

    public boolean deleteStudent(String studentId) {
        StudentEntity entity = studentRepository.findByStudentId(studentId);
        if (entity != null) {
            studentRepository.delete(entity);
            return true;
        }
        return false;
    }

    public Student updateStudent(String studentId, Student updatedStudent) {
        StudentEntity entity = studentRepository.findByStudentId(studentId);
        if (entity != null) {
            entity.setFullName(updatedStudent.getFullName());
            entity.setAge(updatedStudent.getAge());
            StudentEntity saved = studentRepository.save(entity);
            return StudentMapper.toModel(saved);
        }
        return null;
    }

    public Student assignCourses(String studentId, List<String> courseCodes) {
        StudentEntity entity = studentRepository.findByStudentId(studentId);
        if (entity == null) {
            throw new RuntimeException("Student not found");
        }

        List<CourseEntity> courses = courseCodes.stream()
                .map(code -> {
                    CourseRepository courseRepository = null;
                    CourseEntity course = courseRepository.findByCode(code);
                    if (course == null) {
                        throw new RuntimeException("Course with code " + code + " not found");
                    }
                    return course;
                })
                .collect(Collectors.toList());

        entity.setCourses(courses);

        StudentEntity saved = studentRepository.save(entity);
        return StudentMapper.toModel(saved);
    }
}


