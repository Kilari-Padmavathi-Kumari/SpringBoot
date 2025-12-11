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
            deleteInstructorDetails(appDAo);
        };
    }

    private void deleteInstructorDetails(AppDAo appDAo)
    {
        int theId=4;
        System.out.println("Deleteing instructor details id : "+theId);

        appDAo.deleteInstructorDetailsById(theId);
        System.out.println("Done!!!");
    }


}
