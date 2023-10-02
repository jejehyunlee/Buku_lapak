package com.enigma.buku_lapak.service;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/22/2023 08:54
@Last Modified 9/22/2023 08:54
Version 1.0
*/



import com.enigma.buku_lapak.entity.ProductPrice;
import org.springframework.stereotype.Service;

@Service
public interface ProductPriceService {

    ProductPrice create(ProductPrice productPrice);

    ProductPrice getByID(String id);

    ProductPrice findProductPriceActive(String productId, Boolean isActive);

}
