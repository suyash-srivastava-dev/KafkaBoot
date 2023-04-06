package com.ssd.orderservice.Kafka;


import com.ssd.basedomains.DTO.Order;
import com.ssd.basedomains.DTO.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    @Autowired
    private NewTopic topic;

    private KafkaTemplate<String, Order> kafkaTemplate;

    /**
     Constructor
     */
    public OrderProducer(NewTopic topic, KafkaTemplate<String, Order> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }


    /**
     Send Message to Kafka
     */
    public void sendMessage(OrderEvent event)
    {
        System.out.println("Order sent ==> "+event.toString());
        Message<OrderEvent> message= MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC,topic.name()).build();
        kafkaTemplate.send(message);
    }
}
