package com.newproject.springboot_project.rest;

import com.newproject.springboot_project.dao.TeacherDAO;
import com.newproject.springboot_project.entity.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherRestController
{
    private TeacherDAO teacherDAO;

    // quick and dirty: constructor inject Teacher dao
 public TeacherRestController(TeacherDAO theTeacherDAO)
 {
     teacherDAO=theTeacherDAO;
 }
    //expose "/teacher" and return a list of teacher
    @GetMapping("/teacher")
    public List<Teacher> findAll()
    {
        return teacherDAO.findAll();
    }
}
