package com.enigma.buku_lapak.model.request;

import com.enigma.buku_lapak.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import java.util.List;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/25/2023 11:52
@Last Modified 9/25/2023 11:52
Version 1.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderRequest {

    private String customerId;

    private List<OrderDetailRequest> orderDetailRequests;

}
