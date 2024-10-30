package app.bhavitshah.kafka_producer_example.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import app.bhavitshah.dto.Customer;

import org.springframework.kafka.support.SendResult;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToTopic(String message) {

        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("code-1", message);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Error sending message to topic: " + ex.getMessage());
            } else {
                System.out.println("Message sent to topic: " + result.getRecordMetadata().topic() + " Offset "
                        + result.getRecordMetadata().offset());
            }

        });
    }

    public void sendEventsToTopic(Customer object) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("cust-2", 2, null, object);
        future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Error sending message to topic: " + ex.getMessage());
            } else {
                System.out.println("Message sent to topic: " + result.getRecordMetadata().topic() + " Offset "
                        + result.getRecordMetadata().offset() + "   Message  " + object.toString());
            }

        });
    }
}
