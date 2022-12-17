package com.supremepole.adapterjms;

public class MyHelloService implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
