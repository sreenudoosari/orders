package com.myapp.orders.producer;

import com.myapp.orders.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class OrderProducer {

    private static final String TOPIC = "order-created";
    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order) {
        ProducerRecord<String, Order> record = new ProducerRecord<>(TOPIC, order.getOrderId(), order);
        CompletableFuture<SendResult<String, Order>> pendingResult = kafkaTemplate.send(TOPIC, order.getOrderId(), order);
        pendingResult.whenComplete((r, e) -> {
            RecordMetadata metadata = r.getRecordMetadata();
            log.info("Sent order {} to partition {} offset {}", order.getOrderId(), metadata.partition(), metadata.offset());
        });
    }
}
