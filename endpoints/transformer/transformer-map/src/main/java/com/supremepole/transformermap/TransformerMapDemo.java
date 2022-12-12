package com.supremepole.transformermap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class TransformerMapDemo {

    private ApplicationContext ctx = null;
    private MessageChannel inChannel = null;

    public TransformerMapDemo() {
        ctx = new ClassPathXmlApplicationContext("transformer-map.xml");
        inChannel = ctx.getBean("in-channel",MessageChannel.class);
    }

    private void publish() {
        Person person=new Person();
        Message<Person> tradeMsg = MessageBuilder.withPayload(person).build();
        inChannel.send(tradeMsg, 10000);
        System.out.println("Message published.");
    }

    public static void main(String[] args) {
        TransformerMapDemo test = new TransformerMapDemo();
        test.publish();
    }

}
