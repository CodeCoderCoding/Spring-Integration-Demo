package com.supremepole.serviceactivator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class ServiceActivatorString {

    private ApplicationContext applicationContext=null;

    private MessageChannel messageChannel=null;

    public ServiceActivatorString(){
        applicationContext=new ClassPathXmlApplicationContext("service-activator-string.xml");
        messageChannel=applicationContext.getBean("hello-world", MessageChannel.class);
    }

    public void publish(){
        Message<String> message= MessageBuilder.withPayload("Hello World").build();
        messageChannel.send(message, 10000);
    }

    public static void main(String[] args) {
        ServiceActivatorString serviceActivatorString=new ServiceActivatorString();
        serviceActivatorString.publish();
    }

}
