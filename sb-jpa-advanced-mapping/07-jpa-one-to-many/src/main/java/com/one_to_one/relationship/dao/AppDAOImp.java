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
    public InstructorDetails findInstructorDetailsById(int theId)
    {
        return entityManager.find(InstructorDetails.class,theId);
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }
}
