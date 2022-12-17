package com.supremepole.flowrouter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class FlowRouterDemo {

    private ApplicationContext ctx = null;
    private MessageChannel inChannel = null;

    public FlowRouterDemo() {
        ctx = new ClassPathXmlApplicationContext("flow-router.xml");
        inChannel = ctx.getBean("in-channel",MessageChannel.class);
    }

    private void publish() {
        Person person=new Person();
        Message<Person> tradeMsg = MessageBuilder.withPayload(person)
                .setHeader("status", "NEW").build();
        inChannel.send(tradeMsg, 10000);
        System.out.println("Message published.");
    }

    public static void main(String[] args) {
        FlowRouterDemo test = new FlowRouterDemo();
        test.publish();
    }

}
