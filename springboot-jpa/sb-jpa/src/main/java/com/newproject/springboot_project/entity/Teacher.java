package com.newproject.springboot_project.entity;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Entity
@Table(name="Teacher")
public class Teacher
{
    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    //define constructor

    public Teacher()
    {

    }

    public Teacher(String firstName,String lastName,String email)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    //define setter and getter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //define toString method


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @SpringBootApplication
    public static class SpringbootProjectApplication {

        public static void main(String[] args) {
            SpringApplication.run(SpringbootProjectApplication.class, args);
        }

    }
}
