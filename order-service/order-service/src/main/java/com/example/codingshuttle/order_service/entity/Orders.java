package com.example.codingshuttle.order_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // to store enum in the form of string in db , bydefault it is gets stored in the form numbers
    private OrderStatus orderStatus;

    private double totalPrice;

    // This is the inverse side of the relationships
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderItems>items;

}
