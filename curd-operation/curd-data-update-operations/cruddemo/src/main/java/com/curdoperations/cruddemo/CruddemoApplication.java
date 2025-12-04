package com.curdoperations.cruddemo;

import com.curdoperations.cruddemo.dao.StudentDAO;
import com.curdoperations.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
           updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id:primarykey
        int studentId=1;
        System.out.println("Getting student with id : "+studentId);
        Student myStudent=studentDAO.findById(studentId);

        //change first name to "teddy"
        System.out.println("updating student....");
        myStudent.setFirstname("teddy");

        //update the student
        studentDAO.update(myStudent);

        //display the updated student
        System.out.println("updated student.... : "+myStudent);


    }
}


















