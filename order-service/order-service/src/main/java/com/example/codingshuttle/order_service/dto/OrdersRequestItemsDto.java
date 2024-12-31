package com.example.codingshuttle.order_service.dto;

import com.example.codingshuttle.order_service.entity.Orders;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrdersRequestItemsDto  {

    private Long id;

    private Long productId;

    private Integer quantity;

    public Orders orders;
}
