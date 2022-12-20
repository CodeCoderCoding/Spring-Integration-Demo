package com.supremepole.flowsplitter.mysplitter;

import org.springframework.integration.Message;

import java.util.ArrayList;
import java.util.List;

public class MySplitter {

    public List<String> splitMyMessage(Message<?> message){
        List<String> list=new ArrayList<>();
        Person person=(Person)message.getPayload();
        list.add(String.valueOf(person.getId()));
        list.add(person.getName());
        return list;
    }

}
