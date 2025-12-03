package com.curdoperations.cruddemo.dao;

import com.curdoperations.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp1 implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImp1(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee ORDER BY name ASC", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Employee> findByName(String name) {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee WHERE name = :theName", Employee.class);
        theQuery.setParameter("theName", name);
        return theQuery.getResultList();
    }

    /*@Override
    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);
    }*/

  @Override
    @Transactional
    public void deleteById(Integer id) {
        Employee emp = entityManager.find(Employee.class, id);
        entityManager.remove(emp);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Employee").executeUpdate();
    }
}
