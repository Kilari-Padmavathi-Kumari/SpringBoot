package com.newproject.springboot_project.service;

import com.newproject.springboot_project.dao.TeacherDAO;
import com.newproject.springboot_project.entity.Teacher;
import jakarta.transaction.Transactional;
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

    @Override
    public Teacher findByID(int theId) {
        return teacherDAO.findByID(theId);
    }

    @Transactional
    @Override
    public Teacher save(Teacher theTeacher) {
        return teacherDAO.save(theTeacher);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
    teacherDAO.deleteById(theId);
    }
}
