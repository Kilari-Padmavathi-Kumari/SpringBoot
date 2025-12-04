package com.newproject.springboot_project.rest;

import com.newproject.springboot_project.dao.TeacherDAO;
import com.newproject.springboot_project.entity.Teacher;
import com.newproject.springboot_project.service.TeacherService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;

import java.util.List;
import java.util.Map;

import static org.springframework.boot.data.metrics.AutoTimer.apply;

@RestController
@RequestMapping("/api")
public class TeacherRestController
{
    private TeacherService teacherService;

    private ObjectMapper objectMapper;

    // quick and dirty: constructor inject Teacher dao
 public TeacherRestController(TeacherService teacherService,ObjectMapper theobjectMapper)
 {
     this.objectMapper=theobjectMapper;
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
    // add mapping for patch/teacher/{tecahrId}-path teacher... partial update

    @PatchMapping("/teacher/{teacherId}")
    public Teacher patchTeacher(@PathVariable int teacherId,@RequestBody Map<String,Object> patchPayload)
    {
        Teacher tempTeacher=teacherService.findByID(teacherId);

        //throw exception if null

        if(tempTeacher==null)
        {
            throw new RuntimeException("teacher id not found - "+teacherId);
        }
        //throw exception if request body contain "id" key
        if(patchPayload.containsKey("id"))
        {
            throw new RuntimeException("Teacher id not allowed in request body -" +teacherId);
        }
       Teacher patchedTeacher=apply(patchPayload,tempTeacher);

        return teacherService.save(patchedTeacher);
    }

    private Teacher apply(Map<String, Object> patchPayload, Teacher tempTeacher)
    {
        //convert teacher object to a json object node
        ObjectNode teacherNode=objectMapper.convertValue(tempTeacher,ObjectNode.class);

        //convert the patchpayload map to a json object node
        ObjectNode patchNode=objectMapper.convertValue(patchPayload,ObjectNode.class);

        //merge the patch updates into the employee node
        teacherNode.setAll(patchNode);
        return objectMapper.convertValue(teacherNode,Teacher.class);
    }

}

