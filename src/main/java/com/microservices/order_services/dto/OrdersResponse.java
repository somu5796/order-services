package com.microservices.order_services.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@Builder
public class OrdersResponse {
    private Long orderId;
    private Long productId;
    private String productName;
    private Integer quantity;

}
