package com.enigma.buku_lapak.service;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/21/2023 09:48
@Last Modified 9/21/2023 09:48
Version 1.0
*/


import com.enigma.buku_lapak.entity.Store;
import com.enigma.buku_lapak.model.response.CommonResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {

    CommonResponse<Object> create(Store store);
    Store getById(String id);
    List<Store> getAll();
    Store update(Store store);
    void deleteById(String id);

}
