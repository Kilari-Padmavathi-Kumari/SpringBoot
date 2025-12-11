package com.one_to_one.relationship.dao;

import com.one_to_one.relationship.entity.Instructor;
import com.one_to_one.relationship.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    @Transactional
    public void deleteInstructorDetailsById(int theId) {
        InstructorDetails tempInstructorDetails=entityManager.find(InstructorDetails.class,theId);

        //break bi -directional link
        tempInstructorDetails.getInstructor().setInstructorDetails(null);
        entityManager.remove(tempInstructorDetails);
    }
}
