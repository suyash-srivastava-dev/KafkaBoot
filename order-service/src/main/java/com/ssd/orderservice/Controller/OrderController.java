package com.ssd.orderservice.Controller;


import com.ssd.basedomains.DTO.Order;
import com.ssd.basedomains.DTO.OrderEvent;
import com.ssd.orderservice.Kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private OrderProducer orderProducer;
    public OrderController( OrderProducer orderProducer)
    {
        this.orderProducer=orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order)
    {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent= new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status is pending state");
        orderEvent.setOrder(order);
        orderProducer.sendMessage(orderEvent);
        return "Success, placed order.";
    }
}
