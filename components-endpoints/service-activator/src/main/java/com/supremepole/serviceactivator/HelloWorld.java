package com.supremepole.serviceactivator;

import org.springframework.integration.Message;

public class HelloWorld {

    public void helloWorld() {
        System.out.println("hello World");
    }

    public void helloWorldWithString(String string) {
        System.out.println(string);
    }

    public void helloWorldWithMessage(Message<String> message) {
        System.out.println(message.getPayload().toString());
    }

    public Message<String> handleMessage(Message<String> message){
        System.out.println(message);
        return message;
    }

}
