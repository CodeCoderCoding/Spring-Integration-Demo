package com.supremepole.serviceactivator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class ServiceActivatorDemo {

    private ApplicationContext applicationContext=null;

    private MessageChannel messageChannel=null;

    public ServiceActivatorDemo(){
        applicationContext=new ClassPathXmlApplicationContext("service-activator.xml");
        messageChannel=applicationContext.getBean("hello-world", MessageChannel.class);
    }

    public void publish(){
        Message<String> message= MessageBuilder.withPayload("Hello World").build();
        messageChannel.send(message, 10000);
    }

    public static void main(String[] args) {
        ServiceActivatorDemo serviceActivatorDemo=new ServiceActivatorDemo();
        serviceActivatorDemo.publish();
    }

}
