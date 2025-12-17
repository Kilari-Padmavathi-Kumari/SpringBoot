package com.one_to_one.relationship.dao;

import com.one_to_one.relationship.entity.Course;
import com.one_to_one.relationship.entity.InstructorDetails;
import com.one_to_one.relationship.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImp implements AppDAo {

    private final EntityManager entityManager;

    @Autowired
    public AppDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        TypedQuery<Student> query=entityManager.createQuery(
                "select s from Student s "
                        +"JOIN FETCH s.course "
                        +"where s.id=:data",Student.class);
        query.setParameter("data",theId);

        Student student=query.getSingleResult();

        return student;

    }


}
