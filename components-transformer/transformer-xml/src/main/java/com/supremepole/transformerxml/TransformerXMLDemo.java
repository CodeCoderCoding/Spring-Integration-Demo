package com.supremepole.transformerxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class TransformerXMLDemo {

    private ApplicationContext ctx = null;
    private MessageChannel inChannel = null;

    public TransformerXMLDemo() {
        ctx = new ClassPathXmlApplicationContext("transformer-xml.xml");
        inChannel = ctx.getBean("trades-in-channel",MessageChannel.class);
    }

    private void publish() {
        Message<String> tradeMsg = MessageBuilder.withPayload("<trade status='NEW' account='B12D45' direction='BUY'/>").build();
        inChannel.send(tradeMsg, 10000);
        System.out.println("Message published.");
    }

    public static void main(String[] args) {
        TransformerXMLDemo demo = new TransformerXMLDemo();
        demo.publish();
    }

}
