package com.one_to_one.relationship.dao;

import com.one_to_one.relationship.entity.Course;
import com.one_to_one.relationship.entity.InstructorDetails;
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
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {
        TypedQuery<Course> query=entityManager.createQuery(
             "select c from Course c "
             +"JOIN FETCH c.student "
             +"where c.id=:data",Course.class);
        query.setParameter("data",theId);

        Course course=query.getSingleResult();
        return  course;

    }

    @Override
    public InstructorDetails findInstructorDetailsById(int theId) {
        return entityManager.find(InstructorDetails.class, theId);
    }
}
