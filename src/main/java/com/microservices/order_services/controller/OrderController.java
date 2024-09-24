package com.microservices.order_services.controller;

import com.microservices.order_services.dto.OrderRequest;
import com.microservices.order_services.dto.OrdersResponse;
import com.microservices.order_services.manager.impl.OrderServiceManagerImpl;
import com.microservices.order_services.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderServiceManagerImpl orderServiceManager;

    @PostMapping
    public String postOrder(@RequestBody OrderRequest orderRequest){
        String response = orderServiceManager.saveOrders(orderRequest);
        return response!=null? response+" Order saved successfully" : response;
    }

    @GetMapping
    public List<OrdersResponse> getAllOrders(){
        return orderServiceManager.getAllOrders();
    }
}
