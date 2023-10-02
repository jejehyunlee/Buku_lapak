package com.enigma.buku_lapak.model.response;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/21/2023 17:08
@Last Modified 9/21/2023 17:08
Version 1.0
*/

import com.enigma.buku_lapak.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductResponse {

    private String productId;
    private String productName;
    private String productDesc;
    private Long price;
    private Integer stock;
    private StoreResponse store;
}
