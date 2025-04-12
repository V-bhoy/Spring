package com.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansController {
    // SPRING EXPRESSION LANGUAGE
    // it is a powerful expression language that allows to query and manipulate objects at runtime
    // it is written inside #{} and the expression must return some value
    // You can use it:
    //	•	In annotations like @Value
    //	•	In XML configs
    //	•	Inside @Component classes
    // Spring uses the ExpressionParser interface and StandardEvaluationContext.
    // SpEL is useful when:
    //	•	You need to inject dynamic values
    //	•	Access bean properties or methods
    //	•	Apply logic directly inside annotations or config

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Demo demo = context.getBean("demo",Demo.class);
        System.out.println(demo);
    }
}
