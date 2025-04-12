package com.entity;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Pizza {
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "price=" + price +
                '}';
    }

    // @PostConstruct & @PreDestroy are part of java EE
    // deprecated in java 9 and removed in java 11
    // we need to add a dependency javax.annotation-api which is replaced by jakarta to use it in java 11+
    // but even if you add this dependency it won't work,
    // because by default these annotations are disabled
    // To enable it you need to include the context:annotation-config tag
    // which enables all the annotations in our application
    @PostConstruct
    public void init(){
        System.out.println("init method in pizza");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy method in pizza");
    }
}
