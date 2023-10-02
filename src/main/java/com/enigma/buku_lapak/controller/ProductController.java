package com.enigma.buku_lapak.controller;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/21/2023 14:44
@Last Modified 9/21/2023 14:44
Version 1.0
*/

import com.enigma.buku_lapak.entity.Product;
import com.enigma.buku_lapak.entity.ProductPrice;
import com.enigma.buku_lapak.entity.Store;
import com.enigma.buku_lapak.model.request.ProductRequest;
import com.enigma.buku_lapak.model.response.CommonResponse;
import com.enigma.buku_lapak.model.response.PagingResponse;
import com.enigma.buku_lapak.model.response.ProductResponse;
import com.enigma.buku_lapak.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/product")
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping(value = "/v1/add")
    public Product productCreate(@RequestBody Product product) {
        return productService.create(product);
    }

    @PostMapping(
            path = "/v2/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CommonResponse<ProductResponse> create(@RequestBody ProductRequest request) {
        ProductResponse productResponse = productService.createProduct(request);
        return CommonResponse
                .<ProductResponse>builder()
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .message("Success Create")
                .data(productResponse)
                .build();
    }

    @GetMapping(value = "v1/get/{id}")
    public Product productGetId(@PathVariable String id) {
        return productService.getById(id);
    }

    @PutMapping (value = "v1/update")
    public Product productUpdate(@RequestBody Product product) {
        return productService.update(product);
    }


    @GetMapping(value = "v1/get/all")
    public List<Product> storegetAll() {
        return productService.getAll();
    }

    @GetMapping(value = "v2/get/all")
    public ResponseEntity<?> productgetAll(@RequestParam(required = false) String name,
                                                 @RequestParam(required = false) Long maxPrice,
                                                 @RequestParam(required = false , defaultValue = "1") Integer page,
                                                 @RequestParam(required = false, defaultValue = "5") Integer size) {

        Page<ProductResponse> productResponses = productService.searchNameOrPrice(name,maxPrice,page,size);
        PagingResponse pagingResponse = PagingResponse.builder()
                .curentPage(page)
                .totalPage(productResponses.getTotalPages())
                .size(productResponses.getSize())
                .build();

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<PagingResponse>builder()
                        .httpStatus(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Data Found")
//                        .data(pagingResponse)
                        .pagingResponse(pagingResponse)
                        .build());

    }

    @DeleteMapping(value = "v1/delete/{id}")
    public void productDelete(@PathVariable String id) {
        productService.deleteById(id);
    }
}
