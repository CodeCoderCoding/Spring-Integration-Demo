package com.supremepole.bridge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class BridgeDemo {

    private ApplicationContext applicationContext=null;

    private MessageChannel messageChannel=null;

    public BridgeDemo(){
        applicationContext=new ClassPathXmlApplicationContext("bridge.xml");
        messageChannel=applicationContext.getBean("bridge-in-channel", MessageChannel.class);
    }

    public void publish(){
        Message<String> message= MessageBuilder.withPayload("bridge").build();
        messageChannel.send(message, 10000);
    }

    public static void main(String[] args) {
        BridgeDemo bridgeDemo=new BridgeDemo();
        bridgeDemo.publish();
    }

}
