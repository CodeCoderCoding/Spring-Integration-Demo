package com.supremepole.gateway;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GatewayDemo {

    private ApplicationContext applicationContext=null;

    private HelloService helloService=null;

    public GatewayDemo(){
        applicationContext=new ClassPathXmlApplicationContext("gateway.xml");
        helloService=applicationContext.getBean("helloGateway", HelloService.class);
    }

    public void publish(){
        String hello=helloService.sayHello("Hello World");
        //System.out.println(hello);
    }

    public static void main(String[] args) {
        GatewayDemo gatewayDemo=new GatewayDemo();
        gatewayDemo.publish();
    }

}
