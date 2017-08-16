package com.java.spring.aspect.example.component;

import com.java.spring.aspect.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "exampleAction")
public class ExampleAction {

  @Autowired
  private ExampleService exampleService;

  public void welcomeAspect() {
    exampleService.sayHello();
  }
}
