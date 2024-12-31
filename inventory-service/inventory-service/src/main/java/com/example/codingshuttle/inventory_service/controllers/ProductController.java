package com.example.codingshuttle.inventory_service.controllers;

import com.example.codingshuttle.inventory_service.Dto.ProductDto;
import com.example.codingshuttle.inventory_service.entity.Product;
import com.example.codingshuttle.inventory_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllInventory() {
        List<ProductDto> productList = productService.getAllProduct();
        // Debugging: Print the list to ensure proper mapping
        productList.forEach(System.out::println);

        // Returning the list wrapped in ResponseEntity
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto>getProductById(@PathVariable Long id){
        ProductDto productDto = productService.getProductById(id);

        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }




}
