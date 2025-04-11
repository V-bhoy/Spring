package com.controller;

import com.entity.Cake;
import com.entity.Pastry;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansController {
    public static void main(String[] args) {
        // init() & destroy() are lifecycle callback methods
        // they let you define custom logic to run when a bean is created and when it is destroyed.

        // init() - after bean creation
        // This method is called right after the bean is fully constructed and all dependencies are injected.
        // You can use it to:
        //	•	Open database connections
        //	•	Load configuration files
        //	•	Perform setup logic

        // destroy() - before bean removal
        // This method is called when the container is shutting down, and the bean is being removed.
        // Use it to:
        //	•	Close database connections
        //	•	Release resources (threads, sockets, etc.)
        //	•	Perform cleanup

        // Abstract Application context
        // it is a concrete base class in Spring’s hierarchy of context implementations.
        // a richer version of ApplicationContext that gives you more control over the application’s lifecycle.
        // 	•	Support for refreshing, closing, and shutting down the context
        //	•	Support for registering shutdown hooks
        // You’d use it when:
        //	•	You want full control over resource releasing
        //	•	You want to shut down the context gracefully, especially in console-based apps

        // registerShutDownHook()
        //  a method provided by AbstractApplicationContext to ensure that
        //  Spring properly destroys beans and runs any cleanup logic (destroy() methods or @PreDestroy)
        //  when the JVM shuts down.
        // If you don’t register a shutdown hook:
        //	•	Spring won’t know when the JVM is shutting down
        //	•	Beans might not be cleaned up properly
        //	•	Any destroy-method or resource releasing won’t be called
        //  What happens internally?
        //	1.	You call registerShutdownHook()
        //	2.	Spring registers a JVM shutdown hook thread
        //	3.	When you terminate the app (CTRL+C, JVM exit), the hook:
        //	•	Closes the context
        //	•	Calls destroy() on singleton beans
        //	•	Frees resources

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.registerShutdownHook();

        Cake cake = context.getBean("cake", Cake.class);
        System.out.println(cake);

        // implementing lifecycle callbacks using interfaces InitializingBean and DisposableBean
        // when implementing InitializingBean we need to implement method afterPropertiesSet which
        // is similar to init()
        // when implementing DisposableBean we need to implement destroy()

        Pastry pastry = context.getBean("pastry", Pastry.class);
        System.out.println(pastry);
    }
}
