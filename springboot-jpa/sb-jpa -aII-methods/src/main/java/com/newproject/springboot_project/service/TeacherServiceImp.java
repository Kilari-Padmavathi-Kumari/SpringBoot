package com.newproject.springboot_project.service;


import com.newproject.springboot_project.entity.Teacher;
import com.newproject.springboot_project.jpa.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService{

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImp(TeacherRepository teacherRepository)
    {
       this.teacherRepository =teacherRepository;
    }


    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int id) {

        Optional<Teacher> result = teacherRepository.findById(id);
Teacher theTeacher=null;
        if(result.isPresent())
        {
          theTeacher=result.get();
        }
        else {
            //we not find teacher
            throw new RuntimeException("not find teacher id - "+id);
        }
        return theTeacher;
    }

    @Override
    public Teacher update(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(int id) {
        teacherRepository.deleteById(id);

    }
}
