package com.urlnavigator.api.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue myQueue() {
        return new Queue("my-queue");
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("my-queue", message);
        System.out.println("Sent message: " + message);
    }
}

