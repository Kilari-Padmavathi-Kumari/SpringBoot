package com.one_to_one.relationship.dao;

import com.one_to_one.relationship.entity.Course;
import com.one_to_one.relationship.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImp implements AppDAo {

    private final EntityManager entityManager;

    @Autowired
    public AppDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {
        TypedQuery<Course> query=
        return null;
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int theId) {
        return entityManager.find(InstructorDetails.class, theId);
    }
}



import java.util.HashMap;
import java.util.Map;

class A {
    public static void main(String[] args) {
        String str = "aabbcdea";

        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count frequency of each character
        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Build result with characters appearing only once
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (frequencyMap.get(ch) == 1) {
                result.append(ch);
            }
        }

        System.out.println(result.toString());  // Output: "cd e" (without spaces)
    }
} output in strings
