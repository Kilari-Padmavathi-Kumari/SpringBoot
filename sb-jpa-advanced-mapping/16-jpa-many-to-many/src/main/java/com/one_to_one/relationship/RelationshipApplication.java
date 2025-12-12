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
           createCourseAndStudent(appDAo);
        };
    }

    private void createCourseAndStudent(AppDAo appDAo) {
        Course tempCourse=new Course("pacman-how to score points");

        Student tempStudent1=new Student("josh","kilari","kilari@gmail.com");
        Student tempStudent2=new Student("vedha","kilari","kilari@gmail.com");
        Student tempStudent3=new Student("padma","kilari","kilari@gmail.com");

        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);
        tempCourse.addStudent(tempStudent3);

        System.out.println("save the course :"+tempCourse);

        System.out.println("associated students :"+tempCourse.getStudent());

        appDAo.save(tempCourse);

        System.out.println("Done!!!");

    }

    private void saveCourseWithReviews(AppDAo appDAo) {

        // Create InstructorDetails
        InstructorDetails instructorDetails =
                new InstructorDetails("youtube.com/udemy", "coding");

        // Create Instructor
        Instructor instructor =
                new Instructor("John", "Doe", "john@gmail.com");

        instructor.setInstructorDetails(instructorDetails);

        // Create Course
        Course course = new Course("Spring Boot Masterclass");




        // Set instructor to course
        course.setInstructor(instructor);

        // Add reviews
        course.addReview(new Review("Best course!"));
        course.addReview(new Review("Very helpful"));
        course.addReview(new Review("Nice explanation"));

        // Save
        appDAo.save(course);

        System.out.println("Saved course + instructor + reviews!");
    }
}
