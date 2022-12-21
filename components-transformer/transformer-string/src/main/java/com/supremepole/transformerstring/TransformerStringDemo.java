package com.supremepole.transformerstring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class TransformerStringDemo {

    private ApplicationContext ctx = null;
    private MessageChannel inChannel = null;

    public TransformerStringDemo() {
        ctx = new ClassPathXmlApplicationContext("transformer-string.xml");
        inChannel = ctx.getBean("in-channel",MessageChannel.class);
    }

    private void publish() {
        Person person=new Person();
        Message<Person> message = MessageBuilder.withPayload(person).build();
        inChannel.send(message, 10000);
        System.out.println("Message published.");
    }

    public static void main(String[] args) {
        TransformerStringDemo demo = new TransformerStringDemo();
        demo.publish();
    }

}
