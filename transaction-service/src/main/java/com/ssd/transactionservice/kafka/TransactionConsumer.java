package com.ssd.transactionservice.kafka;

import com.ssd.basedomains.DTO.OrderEvent;
import com.ssd.transactionservice.POJO.Orders;
import com.ssd.transactionservice.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {

    @Autowired
    private TransactionRepo transactionRepo;

    @KafkaListener(topics = {"${spring.kafka.topic.name}"},groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event)
    {
        System.out.println();
        System.out.println("Event recieved from topic: "+event.toString());
        System.out.println();
        Orders orders=new Orders();
        orders.setOrderId(event.getOrder().getOrderId());
        orders.setStatus(event.getStatus());
        orders.setMessage(event.getMessage());
        orders.setPrice(event.getOrder().getPrice());
        orders.setQty(event.getOrder().getQty());
        orders.setItemName(event.getOrder().getItemName());

        transactionRepo.save(orders);
    }
}
