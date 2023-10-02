package com.enigma.buku_lapak.model.response;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/25/2023 11:56
@Last Modified 9/25/2023 11:56
Version 1.0
*/

import com.enigma.buku_lapak.entity.Customer;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderResponse {

    private String orderId;

    private LocalDateTime transDate;

    private CustomerResponse customer;

    private List<OrderDetailResponse> orderDetailResponses;
}
