package com.peres.kafka.spring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class FruitConsumer {
    @KafkaListener(topics = "fruit", groupId = "fruit-group-id")
    void consume(String fruit) {
        System.out.println("consumed a fruit: " + fruit);
    }
}