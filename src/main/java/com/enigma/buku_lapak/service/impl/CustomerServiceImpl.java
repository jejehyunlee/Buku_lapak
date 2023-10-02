package com.enigma.buku_lapak.service.impl;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/22/2023 15:29
@Last Modified 9/22/2023 15:29
Version 1.0
*/

import com.enigma.buku_lapak.entity.Customer;
import com.enigma.buku_lapak.model.request.CustomerRequest;
import com.enigma.buku_lapak.model.response.CustomerResponse;
import com.enigma.buku_lapak.repository.CustomerRepository;
import com.enigma.buku_lapak.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public CustomerResponse create(CustomerRequest request) {
                Customer customer = Customer.builder()
                        .idCustomer(request.getIdCustomer())
                        .nameCustomer(request.getNameCustomer())
                        .address(request.getAddress())
                        .mobilePhoneCustomer(request.getMobilePhoneCustomer())
                        .email(request.getEmail())
                        .build();
                 customerRepository.saveAndFlush(customer);


        return CustomerResponse.builder()
                .idCustomer(customer.getIdCustomer())
                .customerName(customer.getNameCustomer())
                .build();
    }

    @Override
    public Customer getById(String id) {

        Customer customer = new Customer();
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAll(String mesage, HttpStatus httpStatus) {
        return customerRepository.findAll();
    }


    @Transactional(rollbackOn = Exception.class)
    @Override
    public Customer update(CustomerRequest request) {
        Customer customer = Customer.builder()
                .idCustomer(request.getIdCustomer())
                .nameCustomer(request.getNameCustomer())
                .address(request.getAddress())
                .mobilePhoneCustomer(request.getMobilePhoneCustomer())
                .email(request.getEmail())
                .build();
       return customerRepository.saveAndFlush(customer);

//        return Customer.builder()
//                .idCustomer(customer.getIdCustomer())
//                .nameCustomer(customer.getNameCustomer())
//                .address(customer.getAddress())
//                .mobilePhoneCustomer(customer.getMobilePhoneCustomer())
//                .email(customer.getEmail())
//                .build();
    }

//    @Override
//    public CustomerResponse update(Customer customer) {
//        Customer customer1 = getById(customer.getIdCustomer());
//        if(customer1 != null){
//            customerRepository.save(customer);
//        }
//        return null;
//    }

    @Override
    public Customer deleteById(String id) {
        customerRepository.deleteById(id);
        return null;
    }
}
