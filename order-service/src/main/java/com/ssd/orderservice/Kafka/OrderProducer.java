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
//    private static final Logger LOGGER= (Logger) LoggerFactory.getLogger(OrderProducer.class);
    @Autowired
    private NewTopic topic;

    private KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(NewTopic topic, KafkaTemplate<String, Order> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(OrderEvent event)
    {
//        LOGGER.info(String.format("Order sent ==> %s",event.toString()));
        System.out.println("Order sent ==> "+event.toString());
        Message<OrderEvent> message= MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC,topic.name()).build();
        kafkaTemplate.send(message);
    }
}
