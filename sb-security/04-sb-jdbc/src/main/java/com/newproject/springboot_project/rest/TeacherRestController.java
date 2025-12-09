package com.newproject.springboot_project.rest;

import com.newproject.springboot_project.entity.Teacher;
import com.newproject.springboot_project.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherRestController {

    private TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/teacher/{id}")
    public Teacher findById(@PathVariable int id) {
        return teacherService.findById(id);
    }

    @PostMapping("/teacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        teacher.setId(0);
        return teacherService.save(teacher);
    }

    @PutMapping("/teacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @DeleteMapping("/teacher/{id}")
    public String deleteTeacher(@PathVariable int id) {
        teacherService.deleteById(id);
        return "Deleted teacher with id - " + id;
    }
}
