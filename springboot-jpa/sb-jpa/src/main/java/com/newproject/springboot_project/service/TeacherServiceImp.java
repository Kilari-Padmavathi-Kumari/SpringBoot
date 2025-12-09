package com.newproject.springboot_project.service;


import com.newproject.springboot_project.entity.Teacher;
import com.newproject.springboot_project.jpa.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService{

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImp(TeacherRepository teacherRepository)
    {
       this.teacherRepository =teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
