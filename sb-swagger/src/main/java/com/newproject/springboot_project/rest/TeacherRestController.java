package com.newproject.springboot_project.rest;

import com.newproject.springboot_project.dao.TeacherDAO;
import com.newproject.springboot_project.entity.Teacher;
import com.newproject.springboot_project.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherRestController
{
    private TeacherService teacherService;

    // quick and dirty: constructor inject Teacher dao
 public TeacherRestController(TeacherService teacherService)
 {
     this.teacherService=teacherService;
 }
    //expose "/teacher" and return a list of teacher
    @GetMapping("/teachers")
    public List<Teacher> findAll()
    {
        return teacherService.findAll();
    }
}
