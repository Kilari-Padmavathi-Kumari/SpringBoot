package com.newproject.springboot_project.service;

import com.newproject.springboot_project.dao.TeacherDAO;
import com.newproject.springboot_project.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService{

    private TeacherDAO teacherDAO;

    @Autowired
    public TeacherServiceImp(TeacherDAO theTeacherDAO)
    {
        teacherDAO=theTeacherDAO;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }
}
