package com.one_to_one.relationship;

import com.one_to_one.relationship.dao.AppDAo;
import com.one_to_one.relationship.entity.Course;
import com.one_to_one.relationship.entity.Instructor;
import com.one_to_one.relationship.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationshipApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AppDAo appDAo)
    {
        return runner->{
            
        findCoursesForInstructor(appDAo);
        };
    }

    private void findCoursesForInstructor(AppDAo appDAo) {
        int theId=1;
        System.out.println("finding instructor id : "+theId);
        Instructor tempInstructor=appDAo.findInstructorById(theId);

        System.out.println("tempInstructor:"+tempInstructor);

        //find courses for instructor
        System.out.println("find courses for Instructor id : "+theId);
        List<Course> course=appDAo.findCoursesByInstructorId(theId);
        tempInstructor.setCourse(course);
        System.out.println("the associated courses : "+tempInstructor.getCourse());
        System.out.println("Done!!");
    }


}
