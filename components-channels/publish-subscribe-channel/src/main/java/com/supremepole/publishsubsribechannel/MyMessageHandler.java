package com.supremepole.publishsubsribechannel;

import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.core.MessageHandler;

public class MyMessageHandler implements MessageHandler {

    public void handleMessage(Message<?> message) throws MessagingException {
        System.out.println("Handling Message:" + message);
    }

}
