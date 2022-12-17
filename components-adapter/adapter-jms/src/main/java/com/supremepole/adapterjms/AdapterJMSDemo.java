package com.supremepole.adapterjms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class AdapterJMSDemo {

    private ApplicationContext ctx = null;

    private void useNameSpace(){
        ctx = new ClassPathXmlApplicationContext("adapter-jms.xml");
        MessageChannel channel=ctx.getBean("outbound-channel", MessageChannel.class);
        Message<String> message= MessageBuilder.withPayload("World").build();
        channel.send(message);
    }

    public static void main(String[] args) {
        AdapterJMSDemo test = new AdapterJMSDemo();
        test.useNameSpace();
    }

}
