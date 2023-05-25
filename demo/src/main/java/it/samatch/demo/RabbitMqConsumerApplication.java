package it.samatch.demo;

import it.samatch.demo.Kafka.KafkaConsumerTEST;
import it.samatch.demo.Kafka.kafkaProducer;
import it.samatch.demo.RabbitMq.RabbitMQProduce;
import it.samatch.demo.RabbitMq.RabbitMqProducerTEST;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqConsumerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RabbitMqConsumerApplication.class, args);
		RabbitMQProduce bc = new RabbitMQProduce();
		bc.Produce();
//		kafkaProducer.StartProducing();
//		KafkaConsumerTEST.StartCosumingTEST();
	}



}
