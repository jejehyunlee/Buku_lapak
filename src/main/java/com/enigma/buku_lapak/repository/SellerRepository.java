package com.enigma.buku_lapak.repository;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 13:21
@Last Modified 10/2/2023 13:21
Version 1.0
*/


import com.enigma.buku_lapak.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, String>{

    Optional<Seller> findByStoreId(String storeId);
}
