package com.supremepole.flowsplitter.mysplitter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

/**
 * 自定义splitter类及方法
 */
public class MySplitterDemo {


    private ApplicationContext applicationContext=null;

    private MessageChannel messageChannel=null;

    public MySplitterDemo(){
        applicationContext=new ClassPathXmlApplicationContext("splitter-my.xml");
        messageChannel=applicationContext.getBean("in-channel", MessageChannel.class);
    }

    public void publish(){
        Person person=new Person();
        Message<Person> message= MessageBuilder.withPayload(person).build();
        messageChannel.send(message, 10000);
    }

    public static void main(String[] args) {
        MySplitterDemo serviceActivatorDemo=new MySplitterDemo();
        serviceActivatorDemo.publish();
    }

}
