package com.configuration;

import com.entity.Coffee;
import com.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.entity")
public class JavaConfig {

    @Bean("coffee2")
    public Coffee getCoffee() {
        return new Coffee();
    }

    @Bean("student2")
    // if the name of the bean is not defined, it uses method name by default
    // both constructor injection and setter injection can be performed using @Bean
    // When using setter injection, object is required first created by no-arg (default) constructor
    // So when injecting values using setter, define default constructor if parameterized constructor
    // is also present, otherwise spring is confused
    public Student getStudent() {
        return new Student(getCoffee());
    }

}
