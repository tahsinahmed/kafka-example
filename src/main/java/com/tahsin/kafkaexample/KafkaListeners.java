package com.tahsin.kafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "test-topic", groupId = "groupId")
    void listener(String data) {
        System.out.println("Message reveived from kafka is: " + data);
    }
}
