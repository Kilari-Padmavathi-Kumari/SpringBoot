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
           deleteStudent(studentDAO);
        };
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId=7;
        System.out.println("deleting student id: "+studentId);
        studentDAO.delete(studentId);

    }
}

/*package com.curdoperations.cruddemo;

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
            deleteAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
    System.out.println("deleting all students");
        int numRowsDeleted=studentDAO.deleteAll();
        System.out.println("deleted row count: "+numRowsDeleted);
        studentDAO.delete(studentId);

    }
}

*/

































