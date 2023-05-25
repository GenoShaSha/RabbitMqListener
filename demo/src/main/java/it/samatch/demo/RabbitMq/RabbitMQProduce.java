package it.samatch.demo.RabbitMq;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQProduce {
    private final static String QUEUE_NAME = "ai-chat-request.queue";

    public void Produce()throws Exception {

//using cloudamqp connected with my github


        try {
            // Create a connection to CloudAMQP
            ConnectionFactory factory = new ConnectionFactory();
            factory.setUri("amqps://opbtfvfc:UqbmIbSLsOGt9yf8z5gSGJGZs6GyRzLv@sparrow.rmq.cloudamqp.com/opbtfvfc"); // Replace with your CloudAMQP URI

            Connection connection = factory.newConnection();

            // Create a channel
            Channel channel = connection.createChannel();

            // Declare a queue for sending messages
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            // Define the message content
            String message = "Hello, RabbitMQ on CloudAMQP!";

            // Publish the message to the queue
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println("Message sent: " + message);

            // Close the channel and connection
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



//        // Create a connection to RabbitMQ
//        ConnectionFactory factory = new ConnectionFactory();
////        factory.setHost("amqps://opbtfvfc:UqbmIbSLsOGt9yf8z5gSGJGZs6GyRzLv@sparrow.rmq.cloudamqp.com/opbtfvfc"); // Replace with the appropriate RabbitMQ server host if needed
//        Connection connection = factory.newConnection();
//
//        // Create a channel
//        Channel channel = connection.createChannel();
//
//        // Declare a queue for sending messages
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//
//        // Define the message content
//        String message = "Hello, RabbitMQ!";
//
//        // Publish the message to the queue
//        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//        System.out.println("Message sent: " + message);
//
//        // Close the channel and connection
//        channel.close();
//        connection.close();
    }
}
