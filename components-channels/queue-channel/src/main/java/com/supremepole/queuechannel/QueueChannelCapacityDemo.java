package com.supremepole.queuechannel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;

public class QueueChannelCapacityDemo {

    private ApplicationContext applicationContext=null;

    private MessageChannel messageChannel=null;

    public QueueChannelCapacityDemo() {
        applicationContext=new ClassPathXmlApplicationContext("queue-channel.xml");
        messageChannel=applicationContext.getBean("queue-channel", MessageChannel.class);
    }

    public void sendMessage(){
        Message<String> message= MessageBuilder.withPayload("Hello World").build();
        messageChannel.send(message, 10000);
    }

    public void receiveMessage(){
        Message<?> message=((QueueChannel) messageChannel).receive(10000);
        System.out.println("Payload: "+message.getPayload());
    }

    public static void main(String[] args) {
        QueueChannelCapacityDemo queueChannelCapacityDemo =new QueueChannelCapacityDemo();
        /**
         * 虽然queue-channel配置的capacity为3，但是往queue-channel中依然发送5条消息，并正常接收处理
         */
        for(int i=0;i<=4;i++){
            queueChannelCapacityDemo.sendMessage();
            queueChannelCapacityDemo.receiveMessage();
        }
    }

}
