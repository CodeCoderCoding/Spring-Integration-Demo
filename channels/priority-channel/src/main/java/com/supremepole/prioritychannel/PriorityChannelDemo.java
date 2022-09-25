package com.supremepole.prioritychannel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.MessageHeaders;
import org.springframework.integration.channel.PriorityChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;

public class PriorityChannelDemo {

    private ApplicationContext applicationContext=null;

    private MessageChannel messageChannel=null;

    public PriorityChannelDemo() {
        applicationContext=new ClassPathXmlApplicationContext("priority-channel.xml");
        messageChannel=applicationContext.getBean("priority-channel", MessageChannel.class);
    }

    public void sendMessage(){
        Message<String> message= MessageBuilder
                .withPayload("Hello World")
                .setHeader(MessageHeaders.PRIORITY, 2)
                .build();
        messageChannel.send(message, 10000);
        message= MessageBuilder
                .withPayload("Hello World")
                .setHeader(MessageHeaders.PRIORITY, 4)
                .build();
        messageChannel.send(message, 10000);
    }

    public void receiveMessage(){
        Message<?> message=((PriorityChannel) messageChannel).receive(10000);
        System.out.println("Payload: "+message.getPayload());
    }

    public static void main(String[] args) {
        PriorityChannelDemo priorityChannelDemo=new PriorityChannelDemo();
        priorityChannelDemo.sendMessage();
        priorityChannelDemo.receiveMessage();
    }

}
