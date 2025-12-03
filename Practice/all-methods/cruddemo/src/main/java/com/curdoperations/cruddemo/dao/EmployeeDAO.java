package com.curdoperations.cruddemo.dao;

import com.curdoperations.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

    void update(Employee employee);

    void deleteById(int id);

    void deleteAll();




}
