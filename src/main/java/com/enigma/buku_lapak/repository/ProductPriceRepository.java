package com.enigma.buku_lapak.repository;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/22/2023 08:55
@Last Modified 9/22/2023 08:55
Version 1.0
*/


import com.enigma.buku_lapak.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, String> {

    Optional<ProductPrice> findByProduct_IdProductAndIsActive(String productId, Boolean isActive);
}
