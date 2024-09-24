package com.microservices.order_services.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@Table(name = "Orders")
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long productId;
    private String productName;
    private Integer quantity;

    public Orders() {
    }

    public Orders(Long productId, String productName, Integer quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    // Optionally, if you want to allow setting orderId as well
    public Orders(Long orderId, Long productId, String productName, Integer quantity) {
        this.orderId = orderId; // Typically, you wouldn't set this manually
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }
}
