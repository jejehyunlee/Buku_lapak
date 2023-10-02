package com.enigma.buku_lapak.controller;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/25/2023 15:24
@Last Modified 9/25/2023 15:24
Version 1.0
*/

import com.enigma.buku_lapak.entity.Order;
import com.enigma.buku_lapak.model.request.OrderRequest;
import com.enigma.buku_lapak.model.request.ProductRequest;
import com.enigma.buku_lapak.model.response.CommonResponse;
import com.enigma.buku_lapak.model.response.OrderResponse;
import com.enigma.buku_lapak.model.response.ProductResponse;
import com.enigma.buku_lapak.service.OrderService;
import com.enigma.buku_lapak.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping( path = "/v2/add")
    public ResponseEntity<?> create(@RequestBody OrderRequest request) {
        OrderResponse orderResponse = orderService.createNewTransaction(request);
        return ResponseEntity.status(HttpStatus.OK.value()).body(
        CommonResponse
                .<OrderResponse>builder()
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .message("Success Create")
                .data(orderResponse)
                .build());
    }
}
