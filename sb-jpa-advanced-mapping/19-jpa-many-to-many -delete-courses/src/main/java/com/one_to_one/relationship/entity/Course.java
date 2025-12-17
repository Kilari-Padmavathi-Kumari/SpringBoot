package com.one_to_one.relationship.entity;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

   @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
   @JoinColumn(name="instructor_id")
    private Instructor instructor;

   @OneToMany(fetch =FetchType.LAZY,cascade = CascadeType.ALL)
   @JoinColumn(name="course_id")
 private List<Review> review;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> student;


    public List<Review> getReview() {
        return review;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }


    public Course()
    {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    // add a convenience method

    public void addReview(Review theReview)
    {
        if(review==null) {
            review = new ArrayList<>();
        }
        review.add(theReview);
    }
    // add a convience method for student

    public void addStudent(Student theStudent)
    {
        if(student==null) {
            student = new ArrayList<>();
        }
        student.add(theStudent);
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +

                '}';
    }

}
