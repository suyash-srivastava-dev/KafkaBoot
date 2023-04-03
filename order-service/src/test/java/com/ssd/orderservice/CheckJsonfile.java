package com.ssd.orderservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssd.basedomains.DTO.Order;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CheckJsonfile {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            AtomicReference<String> s= new AtomicReference<>("");
           List<Order> example = objectMapper.readValue(new File("/media/ubuntu/DataLinux/Mtech/Courses/Sem 2/Subjects/Big Data/presentation/project/order-service/data.json"),new TypeReference<List<Order>>(){});
            example.forEach(i->{
                String d="{ \"data\": \"";

                String p=i.toString().replaceAll("\"","\\\\");
                System.out.println(p);
                s.set(s + d+p+"\"},");
//                System.out.println("{ \"data\": \"{\"itemName\":\"Apple\", \"qty\":10, \"price\":10.0}\"},{ \"data\": \"{\"itemName\":\"Banana\", \"qty\":20, \"price\":20.0}\"},{ \"data\": \"{\"itemName\":\"Orange\", \"qty\":15, \"price\":15.0}\"},{ \"data\": \"{\"itemName\":\"Pineapple\", \"qty\":5, \"price\":25.0}\"},{ \"data\": \"{\"itemName\":\"Kiwi\", \"qty\":15, \"price\":20.0}\"},{ \"data\": \"{\"itemName\":\"Lemon\", \"qty\":10, \"price\":5.0}\"},{ \"data\": \"{\"itemName\":\"Mango\", \"qty\":25, \"price\":15.0}\"},{ \"data\": \"{\"itemName\":\"Strawberry\", \"qty\":20, \"price\":20.0}\"},{ \"data\": \"{\"itemName\":\"Blueberry\", \"qty\":30, \"price\":15.0}\"},{ \"data\": \"{\"itemName\":\"Grapes\", \"qty\":15, \"price\":15.0}\"},{ \"data\": \"{\"itemName\":\"Watermelon\", \"qty\":20, \"price\":20.0}\"},{ \"data\": \"{\"itemName\":\"Cherry\", \"qty\":5, \"price\":5.0}\"},{ \"data\": \"{\"itemName\":\"Tomato\", \"qty\":25, \"price\":10.0}\"},{ \"data\": \"{\"itemName\":\"Cucumber\", \"qty\":20, \"price\":5.0}\"},{ \"data\": \"{\"itemName\":\"Carrot\", \"qty\":15, \"price\":15.0}\"},{ \"data\": \"{\"itemName\":\"Potato\", \"qty\":10, \"price\":10.0}\"},{ \"data\": \"{\"itemName\":\"Onion\", \"qty\":20, \"price\":10.0}\"},{ \"data\": \"{\"itemName\":\"Garlic\", \"qty\":15, \"price\":5.0}\"},{ \"data\": \"{\"itemName\":\"Cabbage\", \"qty\":10, \"price\":15.0}\"},{ \"data\": \"{\"itemName\":\"Bell Pepper\", \"qty\":25, \"price\":20.0}\"},{ \"data\": \"{\"itemName\":\"Peas\", \"qty\":20, \"price\":15.0}\"},{ \"data\": \"{\"itemName\":\"Beans\", \"qty\":5, \"price\":5.0}\"},{ \"data\": \"{\"itemName\":\"Rice\", \"qty\":30, \"price\":30.0}\"},{ \"data\": \"{\"itemName\":\"Wheat\", \"qty\":15, \"price\":25.0}\"},{ \"data\": \"{\"itemName\":\"Maize\", \"qty\":20, \"price\":20.0}\"},{ \"data\": \"{\"itemName\":\"Millets\", \"qty\":10, \"price\":15.0}\"}");
            });
            System.out.println(s);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
