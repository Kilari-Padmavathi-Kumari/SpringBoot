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
    public InstructorDetails findInstructorDetailsById(int theId)
    {
        return entityManager.find(InstructorDetails.class,theId);
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query=entityManager.createQuery(
                "select i from Instructor i "
                +"JOIN FETCH i.course "
                        +"JOIN FETCH i.instructorDetails "
                +"where i.id=:data",Instructor.class);
        query.setParameter("data",theId);

        Instructor instructor=query.getSingleResult();
        return instructor;
    }


}
