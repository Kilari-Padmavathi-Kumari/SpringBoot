package com.curdoperations.cruddemo;

import com.curdoperations.cruddemo.dao.StudentDAO;
import com.curdoperations.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
           // createStudent(studentDAO);
            createMultipleStudents(studentDAO);
        };
    }
    private void createMultipleStudents(StudentDAO studentDAO)
    {
        System.out.println("Creating new student object...");

        // Correct constructor → 3 Strings
        Student tempStudent1 = new Student("josh", "kilari", "kavya@gmail.com");
        Student tempStudent2 = new Student("vedha", "klr", "vedha@gmail.com");
        Student tempStudent3 = new Student("bujji", "kilari", "bujji@gmail.com");
        Student tempStudent4 = new Student("padma", "kpk", "padma@gmail.com");
        Student tempStudent5 = new Student("chitti", "Saripalli", "chitti@gmail.com");

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
        studentDAO.save(tempStudent4);
        studentDAO.save(tempStudent5);


    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object...");

        // Correct constructor → 3 Strings
        Student tempStudent = new Student("Kavya", "Saripalli", "kavya@gmail.com");

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated ID: " + tempStudent.getId());
    }
}
