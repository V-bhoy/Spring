package com.controller;

import com.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansController {
    public static void main(String[] args) {

        // STEREOTYPE ANNOTATIONS
        // class level annotations that tell spring that the class is a spring managed component and
        // spring detects and manages it automatically
        // These annotations are parts of Spring's component scanning feature and help spring
        // to autodetect beans without having a need of bean element
        // For using stereotype annotations, we have to configure xml using context:component-scan
        // tag with base package where spring should scan

        // @Component is used on the class that tell Spring to create an object of that class
        // which we used to define using bean element
        // it will use the class name by default as the id of the bean in lowercase
        // you can define id otherwise in the annotation

        // @Value - annotations specific to beans, it is not a stereotype annotation
        // it is used on the fields to inject values in them
        // for injecting values for a collection field, you can create a standalone collection
        // in xml file and then include its id in @Value enclosed in #{}
        
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Student s1 = context.getBean("s1", Student.class);
        System.out.println(s1);
    }
}
