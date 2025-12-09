package com.newproject.springboot_project.dao;

import com.newproject.springboot_project.entity.Teacher;

import java.util.List;

public interface TeacherDAO
{
    List<Teacher> findAll();
    Teacher findById(int id);
    Teacher save(Teacher teacher);
    void deleteById(int id);
}
