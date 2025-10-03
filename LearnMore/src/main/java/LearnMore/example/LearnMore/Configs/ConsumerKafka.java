package LearnMore.example.LearnMore.Configs;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerKafka {
    /**
     * Listen kafka
     * @param message
     */
    @KafkaListener(topics = "test-topic",
            groupId = "demo_kafka")
    public void listen(String message) {
        System.out.println(message);
    }
}
