package com.supremepole.channel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class HelloWorld {
    public static void main(String args[]) {
        String cfg="channel-context.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(cfg);
        MessageChannel channel=context.getBean("world", MessageChannel.class);
        Message<String> message=MessageBuilder.withPayload("World").build();
        channel.send(message);
    }
}
