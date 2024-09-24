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
//    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

//    @Column(name = "productId")
    private Long pid;

//    @Column(name = "productName")
    private String name;

//    @Column(name = "quantity")
    private Integer quantity;

    public Orders() {
    }

    public Orders(Long productId, String productName, Integer quantity) {
        this.pid = productId;
        this.name = productName;
        this.quantity = quantity;
    }

    // Optionally, if you want to allow setting orderId as well
    public Orders(Long orderId, Long productId, String productName, Integer quantity) {
        this.oid = orderId; // Typically, you wouldn't set this manually
        this.pid = productId;
        this.name = productName;
        this.quantity = quantity;
    }
}
