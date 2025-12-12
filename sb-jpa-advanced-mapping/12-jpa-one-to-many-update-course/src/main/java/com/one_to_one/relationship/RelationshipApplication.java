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
            
        updateCourse(appDAo);
        };
    }

    private void updateCourse(AppDAo appDAo) {
        int theId=10;

        System.out.println("finding Course id :"+theId);
     Course tempCourese=appDAo.findCourseById(theId);

        //update the instructor
        System.out.println("upadting course id:"+theId);
        tempCourese.setTitle("B.tech completed");

        appDAo.update(tempCourese);
        System.out.println("done!!");
    }


}
