package com.supremepole.pollablechannel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;

public class PollableChannelDemo {

    private ApplicationContext applicationContext=null;

    private MessageChannel messageChannel=null;

    public PollableChannelDemo() {
        applicationContext=new ClassPathXmlApplicationContext("pollable-channel.xml");
        messageChannel=applicationContext.getBean("pollable-channel", MessageChannel.class);
    }

    public void sendMessage(){
        Message<String> message= MessageBuilder.withPayload("Hello World").build();
        messageChannel.send(message, 10000);
    }

    public void receiveMessage(){
        Message<?> message=((QueueChannel) messageChannel).receive(10000);
        System.out.println("Payload: "+message.getPayload());
    }

    public static void main(String[] args) {
        PollableChannelDemo pollableChannelDemo=new PollableChannelDemo();
        pollableChannelDemo.sendMessage();
        pollableChannelDemo.receiveMessage();
    }

}
