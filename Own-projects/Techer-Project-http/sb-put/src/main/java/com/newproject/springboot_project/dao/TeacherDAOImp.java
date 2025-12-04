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

    @Override
    public Teacher findByID(int theId)
    {
        //get Teacher
    Teacher theTeacher=entityManager.find(Teacher.class,theId);
        //return Teacher
        return theTeacher;
    }

    @Override
    public Teacher save(Teacher theTeacher) {
        //save Teacher
        Teacher dbTeacher=entityManager.merge(theTeacher);
        //return the dbTeacher
        return dbTeacher;
    }

    @Override
    public void deleteById(int theId) {

            //find Teacher by id
        Teacher theTeacher=entityManager.find(Teacher.class,theId);

        //remove Teacher
        entityManager.remove(theTeacher);

    }
}
