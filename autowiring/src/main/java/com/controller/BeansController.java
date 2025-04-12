package com.controller;

import com.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        // both of these modes use setter injection for injecting dependencies
        // comment out the extra bean for address for observing the output for multiple beans having
        // same type

        // byName mode
        Employee e1 = context.getBean("e1", Employee.class);
        System.out.println(e1);

        // byType mode
        Employee e2 = context.getBean("e2", Employee.class);
        System.out.println(e2);

        // constructor mode
        // if there is no parameterized constructor defined, it will simply print null & not inject anything
        // since it uses constructor injection and will look for a constructor for dependencies
        // in this case we need a parameterized constructor in Employee
        Employee e3 = context.getBean("e3", Employee.class);
        System.out.println(e3);
    }
}
