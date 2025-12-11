package com.one_to_one.relationship;

import com.one_to_one.relationship.dao.AppDAo;
import com.one_to_one.relationship.entity.Course;
import com.one_to_one.relationship.entity.Instructor;
import com.one_to_one.relationship.entity.InstructorDetails;
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
    public CommandLineRunner commandLineRunner(AppDAo appDAo)
    {
        return runner->{
            
      findInstructorWithCourse(appDAo);
        };
    }

    private void findInstructorWithCourse(AppDAo appDAo) {

        int theId=1;
        System.out.println("finding instructor id : "+theId);
Instructor tempInstructor=appDAo.findInstructorById(theId);

System.out.println("tempInstructor:"+tempInstructor);
        System.out.println("the associated courses : "+tempInstructor.getCourse());
        System.out.println("done!!!");

    }










}
