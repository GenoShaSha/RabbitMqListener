package it.samatch.demo.Controller;

import it.samatch.demo.RabbitMq.RabbitMqProducerTEST;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/version1")
public class MessageController {

    private RabbitMqProducerTEST producerTEST;

    public MessageController(RabbitMqProducerTEST producerTEST) {
        this.producerTEST = producerTEST;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> produceMessage(@RequestParam("message") String message){
        producerTEST.produceMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ");

    }
}
