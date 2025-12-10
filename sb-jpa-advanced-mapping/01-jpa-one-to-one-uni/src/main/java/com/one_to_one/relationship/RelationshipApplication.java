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
           createIntructor(appDAo);
        };
    }

    private void createIntructor(AppDAo appDAo) {
       /* //create the intructor
        Instructor tempIntructor=
                new Instructor("kavya","saripalli","kavya@gmail.com");
        InstructorDetails tempIntructorDetails=
                new InstructorDetails("http://www.code/youtbe","eating");*/

        //create the intructor
        Instructor tempIntructor=
                new Instructor("josh","saripalli","josh@gmail.com");
        InstructorDetails tempIntructorDetails=
                new InstructorDetails("http://www.code/youtbe","playing");


        // associate the obj
        tempIntructor.setInstructorDetails(tempIntructorDetails);

        //save the instructor
        // *** this will also save the details obj
        // because of cascadetype.all

        System.out.println("saving instructor : "+tempIntructor);
        appDAo.save(tempIntructor);

        System.out.println("all done!!!!!!");
    }
}
