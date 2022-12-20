package com.supremepole.flowsplitter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class FlowSplitterDemo {


    private ApplicationContext applicationContext=null;

    private MessageChannel messageChannel=null;

    public FlowSplitterDemo(){
        applicationContext=new ClassPathXmlApplicationContext("flow-splitter.xml");
        messageChannel=applicationContext.getBean("in-channel", MessageChannel.class);
    }

    public void publish(){
        Message<String> message= MessageBuilder.withPayload("a, b, c").build();
        messageChannel.send(message, 10000);
    }

    public static void main(String[] args) {
        FlowSplitterDemo serviceActivatorDemo=new FlowSplitterDemo();
        serviceActivatorDemo.publish();
    }

}
