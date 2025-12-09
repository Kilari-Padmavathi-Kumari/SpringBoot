package com.newproject.springboot_project.rest;


import com.newproject.springboot_project.entity.Teacher;
import com.newproject.springboot_project.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherRestController
{
    private TeacherService teacherService;

    // quick and dirty: constructor inject Teacher dao
 public TeacherRestController(TeacherService teacherService)
 {
     this.teacherService=teacherService;
 }
    //expose "/teacher" and return a list of teacher
    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @GetMapping
    public List<Teacher> getAll() {
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getById(@PathVariable int id) {
        return teacherService.findById(id);
    }

    @PutMapping
    public Teacher update(@RequestBody Teacher teacher) {
        return teacherService.update(teacher);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        teacherService.deleteById(id);
        return "Employee deleted: " + id;
    }
}
