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
          deleteCourse(appDAo);
        };
    }

    private void deleteCourse(AppDAo appDAo) {
        int theId=10;
        System.out.println("Deleting course id : "+theId);

        appDAo.deleteCoursesById(theId);

        System.out.println("DOne!!");
    }

    private void addMoreCoursesForStudent(AppDAo appDAo) {
        int theId=2;
        Student tempStudent=appDAo.findStudentAndCoursesByStudentiD(theId);

        Course tempCourse1=new Course("rubik's cbe -how to speed cube");
        Course tempCourse2=new Course("atari 2600 -game development");
        Course tempCourse3=new Course("games's cbe -how to speed cube");

        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);
        tempStudent.addCourse(tempCourse3);

        System.out.println("updating student : "+tempStudent);
        System.out.println("associated courses : "+tempStudent.getCourse());

        appDAo.update(tempStudent);

        System.out.println("Done!!");
    }



}
