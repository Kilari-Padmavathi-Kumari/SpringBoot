package com.one_to_one.relationship;

import com.one_to_one.relationship.dao.AppDAo;
import com.one_to_one.relationship.entity.Course;
import com.one_to_one.relationship.entity.Instructor;
import com.one_to_one.relationship.entity.InstructorDetails;
import com.one_to_one.relationship.entity.Review;
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
            saveCourseWithReviews(appDAo);
        };
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
