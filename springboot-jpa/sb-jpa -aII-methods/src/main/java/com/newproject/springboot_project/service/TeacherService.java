package com.newproject.springboot_project.service;

import com.newproject.springboot_project.entity.Teacher;

import java.util.List;

public interface TeacherService
{

    Teacher save(Teacher teacher);
    List<Teacher> findAll();
    Teacher findById(int id);
    Teacher update(Teacher teacher);
    void deleteById(int id);
}
