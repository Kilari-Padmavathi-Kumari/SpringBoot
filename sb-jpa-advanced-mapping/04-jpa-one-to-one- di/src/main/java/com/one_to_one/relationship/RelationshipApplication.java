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
            
          findInstructorDetails(appDAo);
        };
    }

    private void findInstructorDetails(AppDAo appDAo)
    {
         //get the instructor datail obj
            int theId=4;
            InstructorDetails tempInstructorDetails=appDAo.findInstructorDetailsById(theId);

            //print the instructor detail
            System.out.println("tempInstrucatorDetails : "+tempInstructorDetails);

            //print the associated instructor
            System.out.println("the associated instructor  : " +tempInstructorDetails.getInstructor());

            System.out.println("done !!!!");

        }






}
