package com.enigma.buku_lapak.service.impl;

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
import com.enigma.buku_lapak.repository.ProductPriceRepository;
import com.enigma.buku_lapak.service.ProductPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    @Override
    public ProductPrice create(ProductPrice productPrice) {
        return productPriceRepository.save(productPrice);
    }

    @Override
    public ProductPrice getByID(String id) {
        return productPriceRepository.findById(id).get();
    }

    @Override
    public ProductPrice findProductPriceActive(String productId, Boolean isActive) {
        return productPriceRepository.findByProduct_IdProductAndIsActive(productId,
                isActive).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND, "Product not Found"));
    }

//    @Override
//    public ProductPrice findProductPriceActive(String productId, Boolean isActive) {
//        return productPriceRepository.findByProduct_IdAndIsActive(productId,
//                isActive).orElseThrow(() -> new
//                ResponseStatusException(HttpStatus.NOT_FOUND, "Product not Found"));
//    }
}
