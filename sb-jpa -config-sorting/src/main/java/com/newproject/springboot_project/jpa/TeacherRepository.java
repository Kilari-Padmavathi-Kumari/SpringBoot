package com.newproject.springboot_project.jpa;

import com.newproject.springboot_project.entity.Teacher;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path ="members")
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    // no need to any code
}
