package com.one_to_one.relationship.dao;

import com.one_to_one.relationship.entity.Course;
import com.one_to_one.relationship.entity.Instructor;
import com.one_to_one.relationship.entity.InstructorDetails;

public interface AppDAo {
 InstructorDetails findInstructorDetailsById(int theId);
    void save(Course theCourse);
    Course findCourseAndStudentsByCourseId(int theId);
}
