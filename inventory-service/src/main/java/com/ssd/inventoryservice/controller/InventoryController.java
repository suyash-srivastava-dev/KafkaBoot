package com.ssd.inventoryservice.controller;

import com.ssd.inventoryservice.model.Items;
import com.ssd.inventoryservice.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepo inventoryRepo;
    @PostMapping("/addItem")
    public String placeOrder(@RequestBody Items items)
    {
        inventoryRepo.save(items);
        return "Item added";
    }
    @GetMapping("/allItems")
    public List<Items> getItems()
    {
        return inventoryRepo.findAll();
    }
}
