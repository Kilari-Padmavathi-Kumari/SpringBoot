package com.newproject.springboot_project.dao;

import com.newproject.springboot_project.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAOImp implements TeacherDAO{

    //first define entitymanager
    private EntityManager entityManager;

    //Constructor injection
    @Autowired
    public TeacherDAOImp(EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }
    @Override
    public List<Teacher> findAll()
    {
        //create a query
        TypedQuery<Teacher> theQuery=entityManager.createQuery("from Teacher",Teacher.class);

        //execute query and get result list
        List<Teacher> teachers=theQuery.getResultList();

        //return the results
        return teachers;
    }
}
