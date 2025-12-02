package com.curdoperations.cruddemo.dao;

import com.curdoperations.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
