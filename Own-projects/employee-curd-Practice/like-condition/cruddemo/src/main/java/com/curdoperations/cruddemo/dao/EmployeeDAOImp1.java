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
    public List<Employee> findByNameLike(String theNamePattern) {
        TypedQuery<Employee> theQuery = entityManager.createQuery(
                "from Employee where name like :theData", Employee.class);
        theQuery.setParameter("theData", theNamePattern);  // Pass pattern with wildcards from caller
        return theQuery.getResultList();
    }




}
