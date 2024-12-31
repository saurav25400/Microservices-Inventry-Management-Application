package com.example.codingshuttle.inventory_service.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto  {

    private Long id;


    private String title;


    private Double price;


    private Integer stock;


}
