package com.java.bytecode.client;

import com.java.bytecode.proxy.ProxyHandler;
import com.java.bytecode.subject.RealSubject;
import com.java.bytecode.subject.Subject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;
import sun.misc.ProxyGenerator;

public class MainClient {

  public static void main(String[] args) throws IOException {
    RealSubject real = new RealSubject();
    Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
        new Class[]{Subject.class}, new ProxyHandler(real));
    proxySubject.doSomething();

    //生成代理类的class
    createProxyClassFile();
  }

  private static void createProxyClassFile() throws IOException {
    String name = "ProxySubject";
    byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{Subject.class});
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
