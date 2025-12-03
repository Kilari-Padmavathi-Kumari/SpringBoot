package com.curdoperations.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phnumber")
    private int phnumber;

    @Column(name = "email")
    private String email;

    // No-arg constructor (required by JPA)
    public Employee() {}

    // Parameterized constructor
    public Employee(String name, int phnumber, String email) {
        this.name = name;
        this.phnumber = phnumber;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(int phnumber) {
        this.phnumber = phnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phnumber=" + phnumber +
                ", email='" + email + '\'' +
                '}';
    }
}
