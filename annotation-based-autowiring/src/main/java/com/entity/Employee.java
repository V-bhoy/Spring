package com.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
    private String name;

    @Autowired
    @Qualifier(value = "address2")
    private Address address;
    private Course course;
    private Department department;

    @Autowired
    public Employee(Department department) {
        System.out.println("Using constructor injection for injecting department");
        this.department = department;
    }

    public Employee(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Course getCourse() {
        return course;
    }

    @Autowired
    public void setCourse(Course course) {
        System.out.println("Setting Course through setter injection");
        this.course = course;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", course=" + course +
                ", department=" + department +
                '}';
    }
}
