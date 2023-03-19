package com.ssd.inventoryservice.repo;

import com.ssd.inventoryservice.model.Items;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepo extends MongoRepository<Items,String> {
}
