package com.enigma.buku_lapak.controller;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/22/2023 15:39
@Last Modified 9/22/2023 15:39
Version 1.0
*/


import antlr.collections.impl.LList;
import com.enigma.buku_lapak.entity.Customer;
import com.enigma.buku_lapak.entity.Product;
import com.enigma.buku_lapak.model.request.CustomerRequest;
import com.enigma.buku_lapak.model.response.*;
import com.enigma.buku_lapak.service.CustomerService;
import com.enigma.buku_lapak.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping(
            path = "/v2/add")
    public ResponseEntity<?> create(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.create(customerRequest);
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(CommonResponse
                .<CustomerResponse>builder()
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.CREATED.value())
                .message("Success Create")
                .data(customerResponse)
                .build());
    }

    @GetMapping(path = "/v2/all")
    public GetAllResponse<Customer> getAll() {
        List<Customer> customers = customerService.getAll("OKE", HttpStatus.OK);
        return GetAllResponse
                .<Customer>builder()
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Semua Data Ditemukan")
                .dataList(customers)
                .build();
    }


    @PutMapping(
            path = "/v2/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CommonResponse<Customer> update(@RequestBody CustomerRequest customerRequest) {
        Customer customer = customerService.update(customerRequest);
        return CommonResponse
                .<Customer>builder()
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .message("Success Update")
                .data(customer)
                .build();
    }

    @GetMapping(value = "v2/get/{id}")
    public CommonResponse<Customer> customerGetId(@PathVariable String id) {
        Customer customer = customerService.getById(id);
            return CommonResponse
                    .<Customer>builder()
                    .httpStatus(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .message("Success Get By Id")
                    .data(customer)
                    .build();
    }

    @DeleteMapping(value = "v2/delete/{id}")
    public DeleteResponse customerDelete(@PathVariable String id) {
         Customer customer = customerService.deleteById(id);
            return DeleteResponse.builder()
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message("Berhasil dihapus")
                    .build();
    }

}
