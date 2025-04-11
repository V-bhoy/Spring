package com.controller;

import com.entity.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.List;

public class BeansController {
    public static void main(String[] args) {
        // Resource - core interface, used to load external resources — like:
        //	•	XML files
        //	•	Properties files
        //	•	Text files
        //	•	Even URLs or files from the filesystem
        // It provides a uniform way to access different types of resources, regardless of where they come from.
        // ClassPathResource is a concrete implementation of the Resource interface that loads resources from the classpath.
        // Similarly, we have FileSystemResource, UrlResource, ServletContextResource
        //  In real-world projects, we often split Spring config across multiple XML files
        //  to maintain modularity and manage complexity.

        // Using BEAN FACTORY
        // xml bean factory is removed in spring 6
        // while it is deprecated in spring 5+
        // BeanFactory is the root interface for accessing the Spring IoC container in beans module.
        // XmlBeanFactory - implementation of the BeanFactory interface that allows
        // xml parsing for bean definitions
        // Inject values into beans via constructor or setter injection
        // create beans when requested using getBean()
        // manage its scope and lifecycle
        // here bean is created only when getBean() is called
        // getBean() - used to fetch bean of type Object, which needs to be type casted

        // Resource resource = new ClassPathResource("beans.xml");
        // BeanFactory bf = new XmlBeanFactory(resource);
        // User user = (User) bf.getBean("user");
        // System.out.println(user);

        // Using APPLICATION CONTEXT
        // ApplicationContext extends bean factory providing more features
//        It is responsible for:
//	•	Creating and managing beans
//	•	Injecting dependencies
//	•	Handling events
//	•	Supporting internationalization
//	•	Managing the entire lifecycle of beans
        // It has several implementations like
        //  •	ClassPathXmlApplicationContext
        // - this will load the xml config from the classpath, creates and wires up all the beans in xml
        //	•	FileSystemXmlApplicationContext
        //	•	AnnotationConfigApplicationContext (for Java-based config)
        // getBean() on context takes the id of the bean and its type which helps Spring type-cast the object automatically
        // it returns the bean from the IOC container

        // By default, the container uses setter injection defined by property tag in xml
        // if value is not provided, the container wont call the setter method and print null
        // Spring only injects what you specify
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml",
                "collection_beans.xml", "reference_beans.xml", "constructor_injection.xml");
        // The bean is created in advance  as soon as the application context is instantiated
        // user3 and user1 is pointing to the same bean, since the bean scope is singleton by default
        User user1 = context.getBean("user1", User.class);
        User user2 = context.getBean("user2", User.class);
        User user3 = context.getBean("user1", User.class);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3 == user1);

        System.out.println("\n-------------------------------------------------------------\n");

        // injecting collections
        Employee employee = context.getBean("e1", Employee.class);
        System.out.println(employee);

        System.out.println("\n-------------------------------------------------------------\n");

        // injecting other bean through reference
        B b = context.getBean("b1", B.class);
        A a = context.getBean("a1", A.class);
        System.out.println(a);
        System.out.println(b);

        System.out.println("\n-------------------------------------------------------------\n");

        // constructor injection setting fields via constructor using constructor-arg tag in xml
        Person p1 = context.getBean("p1", Person.class);
        System.out.println(p1);
    }

}
