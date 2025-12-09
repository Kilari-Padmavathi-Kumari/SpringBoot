package com.newproject.springboot_project.jpa;

import com.newproject.springboot_project.entity.Teacher;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    // no need to any code
}
