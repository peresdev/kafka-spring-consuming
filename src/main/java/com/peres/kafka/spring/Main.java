package com.peres.kafka.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableKafka
@EnableScheduling
@SpringBootApplication
public class Main {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static final int EVERY_FIVE_SECONDS = 5 * 100;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Scheduled(fixedDelay = EVERY_FIVE_SECONDS)
    void createFruits() {
        this.kafkaTemplate.send("fruit", new Fruit().setName("Orange").toString());
        logger.info("post-fruit-to-kafka");
    }
}
