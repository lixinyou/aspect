package com.java.spring.aspect.example.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service(value = "exampleService")
public class ExampleServiceImp implements ExampleService {

  private Log logger = LogFactory.getLog(ExampleServiceImp.class);

  public void sayHello() {
    logger.info("Hello Aspect!");
  }
}
