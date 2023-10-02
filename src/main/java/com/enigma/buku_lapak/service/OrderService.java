package com.enigma.buku_lapak.service;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/25/2023 13:13
@Last Modified 9/25/2023 13:13
Version 1.0
*/


import com.enigma.buku_lapak.model.request.OrderRequest;
import com.enigma.buku_lapak.model.response.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createNewTransaction(OrderRequest orderRequest);
    OrderResponse getOrderById(String id);
    List<OrderResponse> getAllTransaction();

    /*
    * Update -> Optional (Tergantung Bisnis)
    * Delete -> Optional (Tergantung Bisnis)
    * */

}
