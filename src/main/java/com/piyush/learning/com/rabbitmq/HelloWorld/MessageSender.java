package com.piyush.learning.com.rabbitmq.HelloWorld;

/**
 * Created by piyush on 7/15/14.
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;

public class MessageSender {

    private final static String QUEUE_NAME = "Hello";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //String message = "Hello World!";

        List<String> msgList = getMessage();

        for(String message : msgList){
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }


    public static ArrayList<String> getMessage(){

        ArrayList <String> msgList= new ArrayList<String>();

        for(int i=0;i<10000;i++){
            String msg = "Hello " + i;
            msgList.add(msg);

        }

        return msgList;

    }
}