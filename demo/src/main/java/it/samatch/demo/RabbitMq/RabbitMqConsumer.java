package it.samatch.demo.RabbitMq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){

        LOGGER.info(String.format("Recieved message -> %s",message));
    }

}
