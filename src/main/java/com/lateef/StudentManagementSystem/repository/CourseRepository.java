package com.lateef.StudentManagementSystem.repository;

import com.lateef.StudentManagementSystem.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    boolean existsByCode(String code);
    CourseEntity findByCode(String code);
}

