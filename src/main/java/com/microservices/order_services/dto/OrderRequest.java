package com.microservices.order_services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Long id;
    private String productName;
    private int quantity;
    private Long productId;

}
