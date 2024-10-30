package app.bhavitshah.kafka_producer_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.bhavitshah.dto.Customer;
import app.bhavitshah.kafka_producer_example.service.KafkaMessagePublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        for (int i = 0; i < 10000; i++) {
            kafkaMessagePublisher.sendMessageToTopic(message + " " + i);
        }
        return ResponseEntity.ok("Message Published");
    }

    @PostMapping("/publish")    
    public void sendEvents(@RequestBody Customer customer){
        kafkaMessagePublisher.sendEventsToTopic(customer);
    }

}
