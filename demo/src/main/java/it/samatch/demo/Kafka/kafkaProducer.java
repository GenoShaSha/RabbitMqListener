package it.samatch.demo.Kafka;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class kafkaProducer {


    public static void StartProducing() {
        var props = new Properties();
        props.put("bootstrap.servers", "talented-salmon-13925-eu1-kafka.upstash.io:9092");
        props.put("sasl.mechanism", "SCRAM-SHA-256");
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"dGFsZW50ZWQtc2FsbW9uLTEzOTI1JHRS5L6rNyvE5kYig8eSQ4VwhCP_lFVgUzg\" password=\"d282ca8e92fe4662adb461509cc8d013\";");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        List<String> topicList = new ArrayList<String>(); // Create a list of strings

        // Add elements to the list
        topicList.add("General");

        try (var producer = new KafkaProducer<String, String>(props)) {
            // Start producing messages
            for (String topic : topicList){
                produceMessages(producer,topic);
            }
        }
    }

    private static void produceMessages(KafkaProducer<String, String> producer,String topic) {
        // Create a loop to simulate message production
        for (int i = 0; i < 10; i++) {
            String key = "Key " + i;
            String value = "Message " + i;
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
            producer.send(record);
            System.out.println("Produced message: " + record);
        }
    }

}
