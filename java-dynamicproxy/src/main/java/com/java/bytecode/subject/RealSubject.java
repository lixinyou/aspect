package com.java.bytecode.subject;

public class RealSubject implements Subject {

  public void doSomething() {
    System.out.println("call doSomething()");
  }

  public void doHello() {
    System.out.println("call doHello()");
  }

  @Override
  public String toString() {
    String str = "toString";
    System.out.println(str);
    return str;
  }
}
