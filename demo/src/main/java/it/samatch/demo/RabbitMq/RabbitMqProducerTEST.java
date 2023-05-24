package it.samatch.demo.RabbitMq;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
public class RabbitMqProducerTEST {
    @Value("${rabbtmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducerTEST.class);

    public RabbitMqProducerTEST(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceMessage(String message){
        LOGGER.info(String.format("Message sent -> %s",message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
