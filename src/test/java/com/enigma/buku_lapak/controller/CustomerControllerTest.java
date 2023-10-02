//package com.enigma.buku_lapak.controller;
//
//import com.enigma.buku_lapak.entity.Customer;
//import com.enigma.buku_lapak.model.request.CustomerRequest;
//import com.enigma.buku_lapak.model.response.CustomerResponse;
//import com.enigma.buku_lapak.service.CustomerService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//class CustomerControllerTest {
//
//    @MockBean
//    private CustomerService customerService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    @Test
//    void isShouldCreateCustomerAndRetrunCustomerResponseOfCustomerAndStatusCode() throws Exception {
//        //Data Dummy Customer
////
//    }
//
//
//    @Test
//    void getAll() {
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void customerGetId() {
//    }
//
//    @Test
//    void customerDelete() {
//    }
//}