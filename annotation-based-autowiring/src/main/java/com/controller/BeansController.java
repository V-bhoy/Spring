package com.controller;

import com.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        // When using annotations by default is disabled to enable it, use context:annotation-config
        // in xml
        // using @Autowired annotation on field for address entity
        // field-injection is used,  it is directly injecting the dependency into the field
        // resulting in tight coupling, hard to test
        // using @Autowired annotation on setter method for course entity
        // spring calls setter method for injecting course (setter injection)
        // using @Autowired annotation on constructor for department entity
        // spring calls constructor method for injecting department (constructor injection)
        Employee e1 = context.getBean("e1", Employee.class);
        System.out.println(e1);

    }
}
