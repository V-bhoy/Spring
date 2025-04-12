package com.entity;

public class Employee {
    private String name;
    private Address address;

    public Employee(Address address) {
        System.out.println("Using constructor injection");
        this.address = address;
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
        System.out.println("Setting Address");
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
