package it.samatch.demo;

import it.samatch.demo.Kafka.KafkaConsumerTEST;
import it.samatch.demo.Kafka.kafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqConsumerApplication.class, args);
//		kafkaProducer.StartProducing();
//		KafkaConsumerTEST.StartCosumingTEST();
	}



}
