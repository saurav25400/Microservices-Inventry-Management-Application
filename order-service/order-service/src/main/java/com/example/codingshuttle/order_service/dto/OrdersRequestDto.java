package com.example.codingshuttle.order_service.dto;


import com.example.codingshuttle.order_service.entity.OrderItems;
import com.example.codingshuttle.order_service.entity.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrdersRequestDto  {


    private Long id;

    private OrderStatus orderStatus;

    private double totalPrice;

    // This is the inverse side of the relationships
    List<OrderItems> items;

}
