package com.curdoperations.cruddemo.dao;

import com.curdoperations.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee);

    Employee findById(Integer id);

    List<Employee> findAll();

    List<Employee> findByName(String name);

    void update(Employee employee);

   /* void deleteById(Integer id);

    int deleteAll();*/
}
