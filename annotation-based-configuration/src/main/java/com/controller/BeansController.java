package com.controller;

import com.configuration.JavaConfig;
import com.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeansController {

    // ANNOTATION BASED CONFIGURATION
    // @Configuration
    // Until now we used xml file to configure the bean definition
    // Now we need to create a separate class that will contain all the bean definitions
    // The class having @Configuration annotation indicates that this class can be used
    // as a source of bean definitions by the IOC container
    // @ComponentScan
    // When we use @Component to indicate a class as a spring managed component used to create a bean
    // and manage automatically
    // we use @ComponentScan along with @Configuration to define the base package for spring to
    // scan the components in order to configure the beans and inject values into them
    // Here JavaConfig class is defined as the configuration class
    // @Bean
    // In order to create an object from a class, we either defined it as a bean element in xml file
    // or defined it using @Component annotation
    // There is one more way to to tell spring to instantiate a Java class and that is done by @Bean
    // This annotation tells spring to manage a method that returns an object as a bean
    // When using @Bean there is no need of using @ComponentScan since it is not a part of
    // component scan feature

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        // using @Component
        Student student = context.getBean("student", Student.class);
        // using @Bean
        Student student2 = context.getBean("student2", Student.class);

        System.out.println(student);
        System.out.println(student2);
        student.doStudy();
        student2.doStudy();
    }
}
