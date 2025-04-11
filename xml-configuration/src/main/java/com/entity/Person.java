package com.entity;

public class Person {
    private int id;
    private String name;
    private Certificate certificate;

    public Person(int id, String name, Certificate certificate) {
        System.out.println("Person constructor called");
        // this is printed when application context is instantiated
        this.id = id;
        this.name = name;
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", certificate=" + certificate +
                '}';
    }
}
