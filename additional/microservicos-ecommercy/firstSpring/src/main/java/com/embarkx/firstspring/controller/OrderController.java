package com.embarkx.firstspring.controller;

import com.embarkx.firstspring.dto.OrderResponse;
import com.embarkx.firstspring.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public ResponseEntity<OrderResponse> createOrder(@RequestHeader("X-User_ID") String userId){
        OrderResponse orderResponse = orderService.createOrder
    }
}
