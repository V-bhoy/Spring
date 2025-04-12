package com.entity;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
    //arithmetic expression
    @Value("#{10+20}")
    private int x;

    // accessing static method - T(class).method
    @Value("#{T(java.lang.Math).sqrt(25)}")
    private int y;

    //accessing static variable - T(class).variable
    @Value("#{T(java.lang.Math).PI}")
    private double z;

    // conditional
    @Value("#{40>50 ? 'Pass' : 'Fail'}")
    private String status;

    // boolean
    @Value("#{24>18}")
    private boolean isAdult;


    @Override
    public String toString() {
        return "Demo{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", status='" + status + '\'' +
                ", isAdult=" + isAdult +
                '}';
    }
}
