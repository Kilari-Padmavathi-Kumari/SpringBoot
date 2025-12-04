package com.curdoperations.cruddemo.dao;

import com.curdoperations.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    List<Employee> findByNameLike(String theNamePattern);

}
