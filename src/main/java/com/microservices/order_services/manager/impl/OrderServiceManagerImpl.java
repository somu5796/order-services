package com.microservices.order_services.manager.impl;

import com.microservices.order_services.dto.OrderRequest;
import com.microservices.order_services.dto.OrdersResponse;
import com.microservices.order_services.model.Orders;
import com.microservices.order_services.repositories.OrderRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceManagerImpl {

    @Autowired
    private OrderRepository orderRepository;
    public String saveOrders(OrderRequest orderRequest){
         Orders order = orderRepository.save( mapDtoToentity(orderRequest));
         return order!=null? order.getOid().toString():null;
    }

    private Orders mapDtoToentity(OrderRequest orderRequest) {
        return Orders.builder()
                .pid(orderRequest.getProductId())
                .name(orderRequest.getProductName())
                .quantity(orderRequest.getQuantity())
                .build();
    }

    public List<OrdersResponse> getAllOrders() {
        return orderRepository.findAll().stream().map(this::mapEntityToDto).toList();
    }

    private OrdersResponse mapEntityToDto(Orders orders) {
        return OrdersResponse.builder().productId(orders.getPid())
                .productName(orders.getName())
                .quantity(orders.getQuantity())
                .orderId(orders.getOid())
                .build();
    }
}
