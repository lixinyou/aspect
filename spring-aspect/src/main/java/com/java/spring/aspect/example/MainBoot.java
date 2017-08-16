package com.java.spring.aspect.example;

import com.java.spring.aspect.example.component.ExampleAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBoot {

  public static void main(String[] args) {
    String app = "/application.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(app);
    ExampleAction action = context.getBean("exampleAction", ExampleAction.class);
    action.welcomeAspect();
  }

}
