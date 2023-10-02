package com.enigma.buku_lapak.model.request;

import lombok.*;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderDetailRequest {

    private String productPriceId;

    private Integer quantity;
}
