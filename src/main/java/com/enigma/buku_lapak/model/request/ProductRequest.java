package com.enigma.buku_lapak.model.request;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/21/2023 16:55
@Last Modified 9/21/2023 16:55
Version 1.0
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductRequest {

    private String productId;
    @NotBlank(message = "product name is required")
    private String productName;
    @NotBlank(message = "product desc is required")
    private String productDesc;
    @NotNull(message = "price is required")
    @Min(value = 0, message = "price must be greater equal 0")
    private Long price;
    @NotNull (message = "stock is required")
    @Min(value = 0, message = "stock must be greater equal 0")
    private Integer stock;
    @NotBlank (message = "store ID is required")
    private String storeId;
}
