//package com.enigma.buku_lapak.service.impl;
//
//import com.enigma.buku_lapak.entity.Store;
//import com.enigma.buku_lapak.repository.StoreRepository;
//import com.enigma.buku_lapak.service.StoreService;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
////@SpringBootTest
//class StoreServiceImplTest {
//
//    private final StoreRepository storeRepository = mock(StoreRepository.class);
//    private final StoreService storeService = new StoreServiceImpl(storeRepository);
//
//    @Test
//    void itShouldReturnStoreWhenCreateNewStore() {
//
//        Store dummyStore = new Store();
//        dummyStore.setIdStore("123");
//        dummyStore.setName("Branch-Bekasi");
//
//        /*Mock behavior repo save*/
//        when(storeRepository.save(any(Store.class))).thenReturn(dummyStore);
//
//        /*perform then create operation*/
//        Store createStore= storeService.create(dummyStore);
//
//        /*verify repo save method was called with expected argument*/
//        verify(storeRepository , times(1)).save(dummyStore);
//
//        /*Verivy then the return store matches the expected store*/
//        assertEquals("123", createStore.getIdStore());
//        assertEquals("Branch-Bekasi", createStore.getName());
//
//
//    }
//
//
//    @Test
//    void getById() {
//
//        String strId = "1";
//        Store dummyStore = new Store();
//        dummyStore.setIdStore(strId);
//        dummyStore.setName("Berkah-Bekasi");
//
//        when(storeRepository.findById(strId)).thenReturn(Optional.of(dummyStore));
//
//        /*perform then create operation*/
//        Store retriviedStore = storeService.getById(strId);
//
//        /*verify repo save method was called with expected argument*/
//        verify(storeRepository , times(1)).findById(strId);
//
//        /*Verivy then the return store matches the expected store*/
//        assertEquals(strId, retriviedStore.getIdStore());
//        assertEquals("Berkah-Bekasi", retriviedStore.getName());
//        System.out.println();
//    }
//
//    @Test
//    void getAll() {
//        List<Store> dummyStore = new ArrayList<>();
//        dummyStore.add( new Store("1","123","Berkah-Selalau","bekasi","1902801"));
//        dummyStore.add( new Store("1","123","Berkah-Selalau","bekasi","1902801"));
//        dummyStore.add( new Store("1","123","Berkah-Selalau","bekasi","1902801"));
//
//        when(storeRepository.findAll()).thenReturn(dummyStore);
//
//        /*perform then create operation*/
//        List<Store> retriviedStore = storeService.getAll();
//
//        /*verify repo save method was called with expected argument*/
//        verify(storeRepository , times(1)).findAll();
//
//        assertEquals(dummyStore.size(), retriviedStore.size());
//
//         /*Verivy then the return store matches the expected store*/
//             for ( int i = 0; i <=0; i++){
//             assertEquals(dummyStore.get(i).getIdStore(), retriviedStore.get(i).getIdStore());
//             assertEquals(dummyStore.get(i).getName(), retriviedStore.get(i).getName());
//            }
//    }
//
//    @Test
//    void update() {
//
//        String storeId = "1";
//        Store dummyStoreToUpdate = new Store(storeId,"123 (Update)" , "Store 1" , "Ragunan" , "12308559");
//
//        when(storeRepository.findById(storeId)).thenReturn(Optional.of(new Store(storeId,"123" , "Store 1" , "Ragunan" , "12308559")));
//
//        when(storeRepository.save(dummyStoreToUpdate)).thenReturn(dummyStoreToUpdate);
//
//        Store updateStore = storeService.update(dummyStoreToUpdate);
//
//        verify(storeRepository,times(1)).findById(storeId);
//        verify(storeRepository,times(1)).save(dummyStoreToUpdate);
//
//        assertEquals(dummyStoreToUpdate.getName() , updateStore.getName());
//
//
//    }
//
//    @Test
//    void deleteById() {
//
//        String storeId = "1";
//        storeService.deleteById(storeId);
//        verify(storeRepository, times(1)).deleteById(storeId);
//
//
//    }
//}