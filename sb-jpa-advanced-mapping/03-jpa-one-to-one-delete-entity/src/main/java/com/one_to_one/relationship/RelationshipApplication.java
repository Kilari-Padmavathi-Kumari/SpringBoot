package com.one_to_one.relationship;

import com.one_to_one.relationship.dao.AppDAo;
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

          deleteInstructor(appDAo);
        };
    }

    private void deleteInstructor(AppDAo appDAo) {
        int theId=3;
        System.out.println("deleting Instructor id : "+theId);

        appDAo.deleteInstructorById(theId);
        System.out.println("done !!!!!!!");
    }




}
