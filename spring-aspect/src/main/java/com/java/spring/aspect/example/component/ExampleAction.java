package com.java.spring.aspect.example.component;

import com.java.spring.aspect.example.service.ExampleService;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.ProxyGenerator;

@Component(value = "exampleAction")
public class ExampleAction {

  @Autowired
  private ExampleService exampleService;

  public void welcomeAspect() throws IOException {
    Class<? extends ExampleService> cls = exampleService.getClass();
    createProxyClassFile();
    exampleService.sayHello();
  }


  private static void createProxyClassFile() throws IOException {
    String name = "exampleService";
    byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{ExampleService.class});
    FileOutputStream out = null;
    try {
      out = new FileOutputStream(name + ".class");
      out.write(data);
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (out != null) {
        out.close();
      }
    }
  }
}
