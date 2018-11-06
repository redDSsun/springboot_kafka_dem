package com.example.demo.consumer;


import com.example.demo.entity.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class MessageConsumer {
    private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = "test")
    public void onMessage(String message) throws IOException {
        Message msg = gson.fromJson(message,Message.class);

        System.out.println("-------------------------------"+msg.getId());
    }
}
