package com.supremepole.publishsubsribechannel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.support.MessageBuilder;

public class PublishSubscribeChannelDemo {

    private ApplicationContext applicationContext=null;

    private MessageChannel messageChannel=null;

    public PublishSubscribeChannelDemo() {
        applicationContext=new ClassPathXmlApplicationContext("publish-subscribe-channel.xml");
        messageChannel=applicationContext.getBean("publish-subscribe-channel", MessageChannel.class);
    }

    public void subscribe(){
        ((PublishSubscribeChannel)messageChannel).subscribe(new MyMessageHandler());
    }

    public void publish(){
        Message<String> message= MessageBuilder.withPayload("Hello World").build();
        messageChannel.send(message, 10000);
    }

    public static void main(String[] args) {
        PublishSubscribeChannelDemo publishSubscribeChannelDemo =new PublishSubscribeChannelDemo();
        publishSubscribeChannelDemo.subscribe();
        publishSubscribeChannelDemo.publish();
    }

}
