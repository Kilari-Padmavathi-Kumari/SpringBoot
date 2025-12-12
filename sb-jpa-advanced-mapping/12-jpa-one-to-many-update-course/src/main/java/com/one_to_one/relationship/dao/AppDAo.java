package com.one_to_one.relationship.dao;

import com.one_to_one.relationship.entity.Course;
import com.one_to_one.relationship.entity.Instructor;
import com.one_to_one.relationship.entity.InstructorDetails;

import java.util.List;

public interface AppDAo {
   Course findCourseById(int theId);
    void update(Course tempCourse);
}
