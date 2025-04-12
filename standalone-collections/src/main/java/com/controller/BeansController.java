package com.controller;

import com.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansController {

    // Standalone Collections are used when you want to define a collection
    // (like List, Set, Map, or Properties) as a bean itself, not tied to any specific class.
//    This is helpful when:
//    •	You want to reuse the collection in multiple beans.
//	  • When you want to inject large static lists, maps, or properties from XML
    // Also we can define the class of the collection which we want to specifically use

    // You need to include the util namespace and add util to schema location to have standalone
    // collections in xml
    // You need to link it to the beans using ref attribute with id if collection util

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Person p1 = context.getBean("p1",Person.class);
        System.out.println(p1);
        System.out.println(p1.getFriends().getClass().getName());
        System.out.println(p1.getFeeStructure().getClass().getName());
        System.out.println(p1.getProperties().getClass().getName());
    }
}
