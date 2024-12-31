package com.example.codingshuttle.order_service.controllers;

import com.example.codingshuttle.order_service.dto.OrdersRequestDto;
import com.example.codingshuttle.order_service.services.OrdersServices;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
//@RequiredArgsConstructor
public class OrdersControllers {

    private final OrdersServices ordersServices;

    public OrdersControllers(OrdersServices ordersServices){
        this.ordersServices=ordersServices;
    }



    @GetMapping("/")
    public ResponseEntity<List<OrdersRequestDto>>getAllOrders(HttpServletRequest httpServletRequest){
        List<OrdersRequestDto>orderList=ordersServices.getAllOrders();
        System.out.println(orderList+"orderList");
        return ResponseEntity.ok(orderList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdersRequestDto>getOrderById(@PathVariable Long id){
        OrdersRequestDto orders=ordersServices.getOrderById(id);
        System.out.println(orders+"orders controller");
        return new ResponseEntity<>(orders, HttpStatus.OK);



    }
}
