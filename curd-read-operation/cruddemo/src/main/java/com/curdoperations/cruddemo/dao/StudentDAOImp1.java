package com.curdoperations.cruddemo.dao;

import com.curdoperations.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImp1 implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImp1(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        // create Query

        TypedQuery<Student> theQuery= entityManager.createQuery("From Student", Student.class);

        // return Query result
        return theQuery.getResultList();
    }
}
