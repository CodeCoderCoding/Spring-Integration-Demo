package com.supremepole.flowsplitter;

import org.springframework.integration.Message;

public class SplitterHandler {

    public void handleMessage(Message<String> message){
        System.out.println(message);
    }

}
