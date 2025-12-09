package com.newproject.springboot_project.service;

import com.newproject.springboot_project.entity.Teacher;

import java.util.List;

public interface TeacherService
{
    List<Teacher> findAll();
    Teacher findById(int id);
    Teacher save(Teacher teacher);
    void deleteById(int id);
}
