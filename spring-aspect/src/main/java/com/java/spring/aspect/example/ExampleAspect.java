package com.java.spring.aspect.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ExampleAspect {

  private Log logger = LogFactory.getLog(ExampleAspect.class);

  public void afterAdvice() {
    logger.info("execute afterAdvice!");
  }
}
