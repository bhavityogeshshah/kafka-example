package app.bhavitshah.kafka_producer_example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

    @Bean
    NewTopic creaNewTopic() {
        return new NewTopic("cust-2", 3, (short) 1);
    }
}
