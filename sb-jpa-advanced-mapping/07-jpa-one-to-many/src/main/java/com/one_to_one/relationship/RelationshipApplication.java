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
            
      createInstructorWithCourse(appDAo);
        };
    }

    private void createInstructorWithCourse(AppDAo appDAo) {

        // create the instructor
        Instructor tempInstructor=
                new Instructor("padma","kilari","kilari@gmail.com");

        //create the instructorDetails
        InstructorDetails tempInstructorDetails=new InstructorDetails("http://ww.yotube.com","playing");

        //create the Course
        Course tempcourse=new Course("cse");
        Course tempcourse1=new Course("eee");
        Course tempcourse2=new Course("mech");

        tempInstructor.add(tempcourse);
        tempInstructor.add(tempcourse1);
        tempInstructor.add(tempcourse2);


        tempInstructor.setInstructorDetails(tempInstructorDetails);

        System.out.println("saving instructor : "+tempInstructor);
        System.out.println("the course : "+tempInstructor.getCourse());
        appDAo.save(tempInstructor);
        System.out.println("done!!");

    }








}
