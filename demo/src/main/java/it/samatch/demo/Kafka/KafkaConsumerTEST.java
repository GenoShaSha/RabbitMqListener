package it.samatch.demo.Kafka;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerTEST {


    public static void StartCosumingTEST() {
        var props = new Properties();
        props.put("bootstrap.servers", "talented-salmon-13925-eu1-kafka.upstash.io:9092");
        props.put("sasl.mechanism", "SCRAM-SHA-256");
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"dGFsZW50ZWQtc2FsbW9uLTEzOTI1JHRS5L6rNyvE5kYig8eSQ4VwhCP_lFVgUzg\" password=\"d282ca8e92fe4662adb461509cc8d013\";");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest");
        props.put("group.id", "my-consumer-group"); // Replace with your consumer group name

        try (var consumer = new KafkaConsumer<String, String>(props)) {
            // Subscribe to the topic(s) you want to consume messages from
            consumer.subscribe(Collections.singletonList("General")); // Replace with your actual topic name

            // Start consuming messages
            consumeMessages(consumer);
        }
    }

    private static void consumeMessages(KafkaConsumer<String, String> consumer) {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);

            for (ConsumerRecord<String, String> record : records) {
                String key = record.key();
                String value = record.value();
                System.out.println("Consumed message - Key: " + key + ", Value: " + value);
            }
            // Commit the offsets after processing the records
            consumer.commitSync();
        }
    }
}
