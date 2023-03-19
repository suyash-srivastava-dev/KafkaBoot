package com.ssd.inventoryservice.kafka;

import com.ssd.basedomains.DTO.OrderEvent;
import com.ssd.inventoryservice.model.Items;
import com.ssd.inventoryservice.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {

    @Autowired
    private InventoryRepo inventoryRepo;

    @KafkaListener(topics = {"${spring.kafka.topic.name}"},groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event)
    {
        System.out.println();
        System.out.println("Event recieved from topic: "+event.toString());
        System.out.println();
        Items item=new Items();
        item.setQty(event.getOrder().getQty());
        item.setItemName(event.getOrder().getItemName());
        inventoryRepo.save(item);
    }
}
