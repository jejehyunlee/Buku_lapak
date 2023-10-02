package com.enigma.buku_lapak.service.impl;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/21/2023 14:40
@Last Modified 9/21/2023 14:40
Version 1.0
*/

import com.enigma.buku_lapak.entity.Product;
import com.enigma.buku_lapak.entity.ProductPrice;
import com.enigma.buku_lapak.entity.Store;
import com.enigma.buku_lapak.model.request.ProductRequest;
import com.enigma.buku_lapak.model.response.ProductResponse;
import com.enigma.buku_lapak.model.response.StoreResponse;
import com.enigma.buku_lapak.repository.ProductRepository;
import com.enigma.buku_lapak.service.ProductPriceService;
import com.enigma.buku_lapak.service.ProductService;
import com.enigma.buku_lapak.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final StoreService storeService;
    private final ProductPriceService productPriceService;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        Product product1 = getById(product.getIdProduct());
        if(product1 != null){
            productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }


    @Transactional(rollbackOn = Exception.class)
    @Override
    public ProductResponse createProduct(ProductRequest request) {

        Store store = storeService.getById(request.getStoreId());

        Product product = Product.builder()
                .name(request.getProductName())
                .desc(request.getProductDesc())
                .build();
        productRepository.saveAndFlush(product);

        ProductPrice productPrice = ProductPrice.builder()
                .price(request.getPrice())
                .stock(request.getStock())
                .store(store)
                .product(product)
                .isActive(true)
                .build();
        productPriceService.create(productPrice);

        return toProductResponse(store, product, productPrice);

    }

    private ProductResponse toProductResponse(Store store, Product product, ProductPrice productPrice) {
        return ProductResponse.builder()
                .productId(product.getIdProduct())
                .productName(product.getName())
                .productDesc(product.getDesc())
                .price(productPrice.getPrice())
                .stock(productPrice.getStock())
                .store(StoreResponse.builder()
                        .idStore(store.getIdStore())
                        .nameStore(store.getName())
                        .addressStore(store.getAddress())
                        .build())
                .build();
    }

    @Override
    public Page<ProductResponse> searchNameOrPrice(String name, Long maxPrice, Integer page, Integer size) {
        Specification<Product> specification = ((root, query, criteriaBuilder) ->{

            Join<Product, ProductPrice> productPrices = root.join("productPrice");
                    List<Predicate> predicates = new ArrayList<>();
                    if (name != null){
                         predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name"))
                        ,"%" + name.toLowerCase() + "%"));
                    }
                    if (maxPrice != null){
                        predicates.add(criteriaBuilder.lessThanOrEqualTo(productPrices.get("price"),maxPrice));
                    }
            return query.where(predicates.toArray(new javax.persistence.criteria.Predicate[]{})).getRestriction();
        });

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(specification, pageable);
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product: products.getContent()) {
            Optional<ProductPrice> productPrice = product.getProductPrice().stream().filter(ProductPrice::getIsActive).findFirst();
        if (productPrice.isEmpty())continue;

        Store store = productPrice.get().getStore();

        productResponses.add(toProductResponse(store, product, productPrice.get()));
        }
        return new PageImpl<>(productResponses, pageable, products.getTotalElements());
    }
}
