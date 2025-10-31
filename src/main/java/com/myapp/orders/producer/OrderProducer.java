package com.myapp.orders.producer;

import com.myapp.orders.controller.Order;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final String TOPIC = "order-created";
    private final Producer<String, Order> kafkaProducer;

    public OrderProducer(Producer<String, Order> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void sendOrder(Order order) {
        ProducerRecord<String, Order> record = new ProducerRecord<>(TOPIC, order.getOrderId(), order);
        kafkaProducer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.printf("Sent order %s to partition %d offset %d%n",
                        order.getOrderId(), metadata.partition(), metadata.offset());
            } else {
                System.err.printf("Failed to send order %s: %s%n",
                        order.getOrderId(), exception.getMessage());
            }
        });
    }
}
