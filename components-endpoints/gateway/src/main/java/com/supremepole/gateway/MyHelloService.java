package com.supremepole.gateway;

public class MyHelloService implements HelloService {

    @Override
    public String sayHello(String name) {
      return "Hello " + name;
    }

}
