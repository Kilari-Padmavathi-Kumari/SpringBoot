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
    @Transactional
    public void deleteCoursesById(int id) {

        Course tempCourse = entityManager.find(Course.class, id);

        if (tempCourse != null) {
            entityManager.remove(tempCourse);
        }
    }

    @Override
    public Student findStudentAndCoursesByStudentiD(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s JOIN FETCH s.courses where s.id = :id",
                Student.class
        );
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }
}