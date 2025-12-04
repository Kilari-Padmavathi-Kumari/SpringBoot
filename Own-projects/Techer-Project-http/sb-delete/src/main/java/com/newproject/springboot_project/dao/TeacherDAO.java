package com.newproject.springboot_project.dao;

import com.newproject.springboot_project.entity.Teacher;

import java.util.List;

public interface TeacherDAO
{
    List<Teacher> findAll();

    Teacher findByID(int theId);

    Teacher save(Teacher theTeacher);

    void deleteById(int theId);



}
