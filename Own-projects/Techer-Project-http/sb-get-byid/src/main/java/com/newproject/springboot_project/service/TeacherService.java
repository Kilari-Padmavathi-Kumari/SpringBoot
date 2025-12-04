package com.newproject.springboot_project.service;

import com.newproject.springboot_project.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher findByID(int theId);

    Teacher save(Teacher theTeacher);

    void deleteById(int theId);
}
