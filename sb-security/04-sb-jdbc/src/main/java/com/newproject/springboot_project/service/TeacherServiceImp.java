package com.newproject.springboot_project.service;

import com.newproject.springboot_project.dao.TeacherDAO;
import com.newproject.springboot_project.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService {

    private TeacherDAO teacherDAO;

    @Autowired
    public TeacherServiceImp(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    @Override
    public Teacher findById(int id) {
        return teacherDAO.findById(id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherDAO.save(teacher);
    }

    @Override
    public void deleteById(int id) {
        teacherDAO.deleteById(id);
    }
}
