package app.bhavitshah.kafka_consumer_example.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import app.bhavitshah.dto.Customer;

@Service
public class KafkaMessageListener {
    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "cust-2", groupId = "learn-g-1")
    public void consumeEvents(Customer message) {
        logger.info("Consumed message: {}", message.toString());
    }   
    
}
