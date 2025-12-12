package com.one_to_one.relationship.dao;

import com.one_to_one.relationship.entity.Course;
import com.one_to_one.relationship.entity.Instructor;
import com.one_to_one.relationship.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImp implements AppDAo
{
    private EntityManager entityManager;

    @Autowired
    public AppDAOImp(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    public void deleteInstructorById(int theId) {

//retrive the instructor
Instructor tempInstructor=entityManager.find(Instructor.class,theId);

//get the courses
List<Course> courses=tempInstructor.getCourse();

//break associate of all courses for the instructor
for(Course tempCourse : courses)
{
    tempCourse.setInstructor(null);
}

//delete the instructor
        entityManager.remove(tempInstructor);

    }


}



