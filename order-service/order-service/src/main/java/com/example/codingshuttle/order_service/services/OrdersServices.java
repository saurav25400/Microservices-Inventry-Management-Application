package com.example.codingshuttle.order_service.services;

import com.example.codingshuttle.order_service.dto.OrdersRequestDto;
import com.example.codingshuttle.order_service.entity.Orders;
import com.example.codingshuttle.order_service.exception.ResourceNotFoundException;
import com.example.codingshuttle.order_service.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;

import org.hibernate.query.Order;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.stream.Collectors;

@Service

public class OrdersServices {

    Logger log= LoggerFactory.getLogger(OrdersServices.class);

    private final OrdersRepository ordersRepository;

    private final ModelMapper modelMapper;

    public OrdersServices(OrdersRepository ordersRepository,ModelMapper modelMapper){
        this.ordersRepository=ordersRepository;
        this.modelMapper=modelMapper;
    }

    public List<OrdersRequestDto>getAllOrders(){
       log.info("calling getAllOrders method");

        List<Orders>ordersList=ordersRepository.findAll();
        return ordersList.stream()
                .map(order->modelMapper.map(order, OrdersRequestDto.class))
                .collect(Collectors.toList());

    }


    public OrdersRequestDto getOrderById(Long id) {
        log.info("calling getOrderById method");
        OrdersRequestDto order=ordersRepository.findById(id)
                .map(item->modelMapper.map(item, OrdersRequestDto.class))
                .orElseThrow(()->new ResourceNotFoundException("not found"));
        return order;

    }
}
