package com.ssd.basedomains.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private String itemName;
    private int qty;
    private double price;

    @Override
    public String toString() {
        return "{" +
                "\"itemName\"" + ":\"" + itemName + '"' +
                ", \"qty\":" + qty +
                ", \"price\":" + price +
                '}';
    }
}
