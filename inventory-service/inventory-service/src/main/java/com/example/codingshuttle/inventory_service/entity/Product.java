package com.example.codingshuttle.inventory_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
@Data
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stock;


}
