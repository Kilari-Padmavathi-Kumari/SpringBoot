package com.newproject.springboot_project.dao;

import com.newproject.springboot_project.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TeacherDAOImp implements TeacherDAO {

    private EntityManager entityManager;

    @Autowired
    public TeacherDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Teacher> findAll() {
        TypedQuery<Teacher> query =
                entityManager.createQuery("from Teacher", Teacher.class);
        return query.getResultList();
    }

    @Override
    public Teacher findById(int id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    @Transactional
    public Teacher save(Teacher teacher) {
        return entityManager.merge(teacher);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        entityManager.remove(teacher);
    }
}
