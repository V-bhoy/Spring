package com.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {


    private Coffee coffee;

    @Autowired
    public Student(@Qualifier(value = "coffee") Coffee coffee) {
        this.coffee = coffee;
    }

    public void doStudy(){
        System.out.println("Hello I am studying....");
        coffee.display();
    }
}
