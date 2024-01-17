package com.enigma.buku_lapak.service;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/22/2023 15:27
@Last Modified 9/22/2023 15:27
Version 1.0
*/


import com.enigma.buku_lapak.entity.Customer;
import com.enigma.buku_lapak.model.request.CustomerRequest;
import com.enigma.buku_lapak.model.response.CommonResponse;
import com.enigma.buku_lapak.model.response.CustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer create(Customer customer);
    Customer getById(String id);
    List<Customer> getAll(String mesage, HttpStatus httpStatus);
    Customer update(CustomerRequest customerRequest);
    Customer deleteById(String id);
}
