package com.one_to_one.relationship;

import com.one_to_one.relationship.dao.AppDAo;
import com.one_to_one.relationship.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RelationshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelationshipApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAo appDAo) {
        return runner -> {
          findStudentAndCourses(appDAo);
        };
    }

    private void findStudentAndCourses(AppDAo appDAo) {
        int theId=2;
        Student tempStudent=appDAo.findStudentAndCoursesByStudentId(theId);

        System.out.println("load student : "+tempStudent);

        System.out.println("student : "+tempStudent.getCourse());

        System.out.println("Done!!");
    }

}
