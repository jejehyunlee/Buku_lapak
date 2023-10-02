package com.enigma.buku_lapak.service.impl;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/21/2023 09:55
@Last Modified 9/21/2023 09:55
Version 1.0
*/

import com.enigma.buku_lapak.entity.Store;
import com.enigma.buku_lapak.repository.StoreRepository;
import com.enigma.buku_lapak.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store create(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getById(String id) {
        return storeRepository.findById(id).get();
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store update(Store store) {
        Store store1 = getById(store.getIdStore());
        if(store1 != null){
            storeRepository.save(store);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        storeRepository.deleteById(id);
    }
}
