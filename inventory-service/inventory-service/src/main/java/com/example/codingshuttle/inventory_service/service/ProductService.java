package com.example.codingshuttle.inventory_service.service;

import com.example.codingshuttle.inventory_service.Dto.ProductDto;
import com.example.codingshuttle.inventory_service.entity.Product;
import com.example.codingshuttle.inventory_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ProductService {
    // to create single instance of the class
   private static final Logger log= LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository,ModelMapper modelMapper){
        this.productRepository= productRepository;
        this.modelMapper=modelMapper;
    }

    public List<ProductDto> getAllProduct() {
        log.info("running getAllProduct method in service layer");

        List<Product>productList=productRepository.findAll();
        System.out.println(productList+" coming from service");
        if(productList.isEmpty()){
            log.info("productList is empty");
        }

        List<ProductDto> productDtoList = productList.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());

       return productDtoList;
    }

    public ProductDto getProductById(Long id) {
        Optional<Product> product=productRepository.findById(id);
        ProductDto products=product.map(item->modelMapper.map(item,ProductDto.class))
                .orElseThrow(()->new RuntimeException("product not found"));
        return products;
    }
}
