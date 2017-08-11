package com.java.bytecode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

  private Object proxied;

  public ProxyHandler(Object proxied) {
    this.proxied = proxied;
  }

  private void preInvoke() {
    System.out.println("before invoke!");
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    preInvoke();
    Object retObj = method.invoke(proxied, args);
    postInvoke();
    return retObj;
  }

  private void postInvoke() {
    System.out.println("after invoke");
  }
}
