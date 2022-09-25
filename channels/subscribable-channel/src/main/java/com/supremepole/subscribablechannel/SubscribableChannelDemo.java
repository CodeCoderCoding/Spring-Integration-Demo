package com.supremepole.subscribablechannel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.support.MessageBuilder;

public class SubscribableChannelDemo {

    private ApplicationContext applicationContext=null;

    private MessageChannel messageChannel=null;

    public SubscribableChannelDemo() {
        applicationContext=new ClassPathXmlApplicationContext("subscribable-channel.xml");
        messageChannel=applicationContext.getBean("subscribable-channel", MessageChannel.class);
    }

    public void subscribe(){
        ((PublishSubscribeChannel)messageChannel).subscribe(new MyMessageHandler());
    }

    public void publish(){
        Message<String> message= MessageBuilder.withPayload("Hello World").build();
        messageChannel.send(message, 10000);
    }

    public static void main(String[] args) {
        SubscribableChannelDemo subscribableChannelDemo=new SubscribableChannelDemo();
        subscribableChannelDemo.subscribe();
        subscribableChannelDemo.publish();
    }

}
