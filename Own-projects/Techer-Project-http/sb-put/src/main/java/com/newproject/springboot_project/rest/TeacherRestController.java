package com.newproject.springboot_project.rest;

import com.newproject.springboot_project.dao.TeacherDAO;
import com.newproject.springboot_project.entity.Teacher;
import com.newproject.springboot_project.service.TeacherService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/teachers/{teacherId}")
    public Teacher getTeacher(@PathVariable int teacherId)
    {
        Teacher theTeacher=teacherService.findByID(teacherId);
        if(theTeacher==null)
        {
            throw new RuntimeException("Teacher id not found - "+teacherId);
        }
        return theTeacher;
    }
    //add mapping for post /teacher -add new teacher
    @PostMapping("/teachers")
    public Teacher addTeacher(@RequestBody Teacher theTeacher)
    {
        //also just in case they pass an id in json ...set id to 0
        //this is to force a save of new item .. instead of update
        theTeacher.setId(0);

        Teacher dbTeacher=teacherService.save(theTeacher);
        return dbTeacher;
    }

    //add mapping for put/teacher -update existing teacher
    @PutMapping("teachers")
    public Teacher updateTeacher(@RequestBody Teacher theTeacher)
    {
        return teacherService.save(theTeacher);
    }
}

