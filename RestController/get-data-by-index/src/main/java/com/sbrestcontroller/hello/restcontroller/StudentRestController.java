package com.sbrestcontroller.hello.restcontroller;

import com.sbrestcontroller.hello.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController
{
    private List<Student> obj;
    @PostConstruct
    public void loadData()
    {
        obj=new ArrayList<>();
        obj.add(new Student(1,"padma"));
        obj.add(new Student(2,"kavya"));
        obj.add(new Student(3,"josh"));
        obj.add(new Student(4,"vedha"));

    }
    @GetMapping("/student")
    public List<Student> getStudent()
    {

       return obj;
    }
    //retrieve
    @GetMapping("/student/{studentId}")
    public Student getstu(@PathVariable int studentId)
    {
        //
        return obj.get(studentId);
    }

}
