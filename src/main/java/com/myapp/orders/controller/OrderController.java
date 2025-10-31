package com.myapp.orders.controller;

import com.myapp.orders.producer.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderProducer.sendOrder(order);
        return ResponseEntity.ok("Order sent: " + order.getOrderId());
    }
}
