package com.lateef.StudentManagementSystem.repository;

import com.lateef.StudentManagementSystem.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
    boolean existsByStudentRegNo(String studentRegNo);
    StudentEntity findByStudentRegNo(String studentRegNo);




    StudentEntity findByStudentId(String studentRegNo);
}
