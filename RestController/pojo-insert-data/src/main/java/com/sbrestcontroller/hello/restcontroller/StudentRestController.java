package com.sbrestcontroller.hello.restcontroller;

import com.sbrestcontroller.hello.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController
{
    @GetMapping("/student")
    public List<Student> getStudent()
    {
        List<Student> obj=new ArrayList<>();
        obj.add(new Student(1,"padma"));
        obj.add(new Student(2,"kavya"));
        obj.add(new Student(3,"josh"));
        obj.add(new Student(4,"vedha"));

       return obj;
    }

}
