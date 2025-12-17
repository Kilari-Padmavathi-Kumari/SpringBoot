package com.one_to_one.relationship.dao;

import com.one_to_one.relationship.entity.Course;
import com.one_to_one.relationship.entity.Instructor;
import com.one_to_one.relationship.entity.InstructorDetails;
import com.one_to_one.relationship.entity.Student;

public interface AppDAo {
    void deleteCoursesById(int id);

    Student findStudentAndCoursesByStudentiD(int id);

    void update(Student theStudent);
}
