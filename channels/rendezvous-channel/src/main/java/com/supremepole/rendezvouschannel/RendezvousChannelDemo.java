package com.supremepole.rendezvouschannel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.RendezvousChannel;
import org.springframework.integration.support.MessageBuilder;

public class RendezvousChannelDemo {

    private ApplicationContext applicationContext=null;

    private MessageChannel messageChannel=null;

    public RendezvousChannelDemo() {
        applicationContext=new ClassPathXmlApplicationContext("rendezvous-channel.xml");
        messageChannel=applicationContext.getBean("rendezvous-channel", MessageChannel.class);
    }

    public void sendMessage(){
        Message<String> message= MessageBuilder
                .withPayload("Hello World")
                .build();
        messageChannel.send(message, 10000);
    }

    public void receiveMessage(){
        Message<?> message=((RendezvousChannel) messageChannel).receive(10000);
        System.out.println("Payload: "+message.getPayload());
    }

    public static void main(String[] args) {
        RendezvousChannelDemo rendezvousChannelDemo=new RendezvousChannelDemo();
        rendezvousChannelDemo.sendMessage();
        rendezvousChannelDemo.receiveMessage();
    }

}
