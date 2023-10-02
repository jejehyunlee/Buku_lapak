package com.enigma.buku_lapak.controller;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/20/2023 14:11
@Last Modified 9/20/2023 14:11
Version 1.0
*/

import com.enigma.buku_lapak.entity.Store;
import com.enigma.buku_lapak.service.impl.StoreServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/store")
public class StoreController {

    private final StoreServiceImpl storeService;

    @PostMapping(value = "/v1/add")
    public Store storeCreate(@RequestBody Store store) {
        return storeService.create(store);
    }

    @GetMapping(value = "v1/get/{id}")
    public Store storeGetId(@PathVariable String id) {
        return storeService.getById(id);
    }

    @PutMapping (value = "v1/update")
    public Store storeUpdate(@RequestBody Store store) {
        return storeService.update(store);
    }

    @GetMapping(value = "v1/get/all")
    public List<Store> storegetAll() {
        return storeService.getAll();

    }

    @DeleteMapping(value = "v1/delete/{id}")
    public void storeDelete(@PathVariable String id) {
        storeService.deleteById(id);
    }

//
//    @GetMapping(value = "/hello2{key}")
//    public String helloParam(@RequestParam String key) {
//        return key;
//    }
//
//    @GetMapping(value = "/hello2/{key}")
//    public String helloPathVar(@PathVariable String key) {
//        return "adalah Path Variable" + key;
//    }
//
//    @GetMapping(value = "/employe")
//    public Map<String, Object> helloEmploye() {
//
//        Map<String, Object> objEmploye = new LinkedHashMap<>();
//
//        objEmploye.put("Adress", address());
//
//        ArrayList<String> hobbi = new ArrayList<>();
//        hobbi.add("Bola");
//        hobbi.add("renang");
//        objEmploye.put("hobbi", hobbi);
//
//        objEmploye.put("Nama","Jefri");
//        objEmploye.put("Usia",20);
//
//        return objEmploye;
//    }
//
//    public Map<String, Object> address() {
//        Map<String, Object> objAdr = new HashMap<>();
//        objAdr.put("RT", 10);
//        objAdr.put("RW", 21);
//        objAdr.put("Street", "Jalan. in Ajah");
//
//        return objAdr;
//    }

}
