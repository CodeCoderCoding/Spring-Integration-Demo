package com.supremepole.spring.integration.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class HelloWorldDemo {
    public static void main(String args[]) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-integration-context.xml");
        MessageChannel channel=context.getBean("world", MessageChannel.class);
        Message<String> message=MessageBuilder.withPayload("World").build();
        channel.send(message);
    }
}
