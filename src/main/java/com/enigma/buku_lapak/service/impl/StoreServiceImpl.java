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

import com.enigma.buku_lapak.config.LoggingConfig;
import com.enigma.buku_lapak.entity.Store;
import com.enigma.buku_lapak.model.response.CommonResponse;
import com.enigma.buku_lapak.repository.StoreRepository;
import com.enigma.buku_lapak.service.StoreService;
import com.enigma.buku_lapak.utils.LoggingFile;
import com.enigma.buku_lapak.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private String[] strExceptionArr = new String[2];

    private final StoreRepository storeRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonResponse<Object> create(Store store) {
        try {
            storeRepository.saveAndFlush(store);
        }catch (Exception e){
            strExceptionArr[0] = "StoreServiceImpl Class";
            strExceptionArr[1] = "CommonResponse<Store> create(Store store) --- LINE 37";
            LoggingFile.exceptionStringz(strExceptionArr, e, LoggingConfig.getFlagLogging());
            throw new ResponseStatusException(HttpStatus.CONFLICT, ResponseMessage.getDuplicateResourceMessage(Store.class));
        }
        return CommonResponse.builder()
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Success Create")
                .data(store)
                .build();
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
