package com.supremepole.gateway;

public class MyHelloService implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("hello "+name);
      return "Hello " + name;
    }

    public void handleMessage(String name){
        System.out.println("handle Message"+name);
    }

}
