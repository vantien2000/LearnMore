package LearnMore.example.LearnMore.Configs;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerKafka {
    private KafkaTemplate<String, String> kafkaTemplate;

    public ProducerKafka(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Send a message
     * @param topic: topic of kafka
     * @param message: message need send
     */
    public void send(String topic, String message) {
        this.kafkaTemplate.send(topic, message).whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println(String.format("Send to partition %d with %d",
                        result.getRecordMetadata().partition(), result.getRecordMetadata().offset()));
            } else {
                System.err.println("Failed" + ex.getMessage());
            }
        });
    }

    /**
     * Send multiple messages
     * @param topic: topic of kafka
     * @param messages: collection of messages
     */
    public void sendInTransaction(String topic, List<String> messages) {
        this.kafkaTemplate.executeInTransaction(operations -> {
            for (String message:
                    messages) {
                operations.send(topic, message);
            }

            if (true) {
                throw new RuntimeException("Simulated error");
            }
            System.out.println("Transaction Id" + operations.getProducerFactory().getTransactionIdPrefix());
            return false;
        });
    }
}
