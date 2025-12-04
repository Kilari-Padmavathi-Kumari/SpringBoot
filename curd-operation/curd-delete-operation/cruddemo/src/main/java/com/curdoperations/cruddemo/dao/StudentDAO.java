package com.curdoperations.cruddemo.dao;

import com.curdoperations.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

   void delete(Integer id);





}


/*
package com.curdoperations.cruddemo.dao;

import com.curdoperations.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

   void delete(Integer id);


   void deleteall();


}




}

 */
