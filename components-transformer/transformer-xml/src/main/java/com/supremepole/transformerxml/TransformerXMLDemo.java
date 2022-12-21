package com.supremepole.transformerxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class TransformerXMLDemo {

    private ApplicationContext ctx = null;
    private MessageChannel inChannel = null;
    private String path="./components-transformer/transformer-xml/src/main/resources/";

    public TransformerXMLDemo() {
        ctx = new ClassPathXmlApplicationContext("transformer-xml.xml");
        inChannel = ctx.getBean("out-channel",MessageChannel.class);
    }

    private void publish() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(path+"XMLFile.xml");
        Message<?> message = MessageBuilder.withPayload(document).build();
        inChannel.send(message, 10000);
        System.out.println("Message published.");
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        TransformerXMLDemo demo = new TransformerXMLDemo();
        demo.publish();
    }

}
