package com.controller;

import com.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansController {
    public static void main(String[] args) {

        // BEAN SCOPE
        // it defines how many instances of a bean, Spring should create and how long it should live
        // inside the container

        // you can configure scope either using @Scope annotation with @Component or scope attribute in bean tag
        // in core container, there are 2 scopes available - singleton & prototype
        // singleton is default scope - Only one instance is created and shared across the app.
        // if you create one more object with the same bean id, it will reference the same bean
        // it is eagerly loaded unless lazy-init is set to true
        // prototype - A new instance is created every time you call getBean().
        // the bean is created on demand
        // here, bean s1 has scope prototype (using annotation) & bean s2 singleton (configured using xml)

        // when using webapps, there are 4 scopes available
        // 1. request - one bean per http request
        // 2. session - one bean per http session
        // 3. application - one bean per servlet context
        // 4. websocket - one bean per websocket session
        // 5. Global-session: The scope of the bean definition here is a Global HTTP session.

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Student s1 = context.getBean("s1", Student.class);
        Student s2 = context.getBean("s1", Student.class);
        Student s3 = context.getBean("s2", Student.class);
        Student s4 = context.getBean("s2", Student.class);

        // scope - prototype
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        // scope-singleton
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
    }
}
