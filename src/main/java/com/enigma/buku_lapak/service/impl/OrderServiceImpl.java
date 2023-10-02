package com.enigma.buku_lapak.service.impl;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/25/2023 13:18
@Last Modified 9/25/2023 13:18
Version 1.0
*/

import com.enigma.buku_lapak.entity.Customer;
import com.enigma.buku_lapak.entity.Order;
import com.enigma.buku_lapak.entity.OrderDetail;
import com.enigma.buku_lapak.entity.ProductPrice;
import com.enigma.buku_lapak.model.request.OrderRequest;
import com.enigma.buku_lapak.model.response.*;
import com.enigma.buku_lapak.repository.OrderDetaillRepository;
import com.enigma.buku_lapak.repository.OrderRepository;
import com.enigma.buku_lapak.service.CustomerService;
import com.enigma.buku_lapak.service.OrderService;
import com.enigma.buku_lapak.service.ProductPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CustomerService customerService;
    private final ProductPriceService productPriceService;
    private final OrderRepository orderRepository;

    private final OrderDetaillRepository orderDetaillRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public OrderResponse createNewTransaction(OrderRequest orderRequest) {
        /* TODO 1 : Validate customer*/
        Customer customer = customerService.getById(orderRequest.getCustomerId());
        /*TODO 2 : Convert orderdetil request to OrderDetail*/
        List<OrderDetail> orderDetails = orderRequest.getOrderDetailRequests().stream().map(orderDetailRequest -> {
            //TODO 3 : Validate Product Price
            ProductPrice productPrice = productPriceService.getByID(orderDetailRequest.getProductPriceId());
            return OrderDetail.builder()
                    .productPrice(productPrice)
                    .quantity(orderDetailRequest.getQuantity())
                    .build();
        }).collect(Collectors.toList());
        /* TODO 4 : Create New User*/
        Order order = Order.builder()
                .customer(customer)
                .transDate(LocalDateTime.now())
                .orderDetails(orderDetails)
                .build();
        orderRepository.saveAndFlush(order);

        order.getOrderDetails().forEach(orderDetail -> {
            orderDetail.setOrder(order);
            orderDetaillRepository.save(orderDetail);
        });

        /*TODO 5 : Change the stock from purchase quantity */
        List<OrderDetailResponse> orderDetailResponses = order.getOrderDetails().stream().map(orderDetail -> {
            orderDetail.setOrder(order);
            ProductPrice currentProductPrice = orderDetail.getProductPrice();
            currentProductPrice.setStock(currentProductPrice.getStock() - orderDetail.getQuantity());
            return OrderDetailResponse.builder()
                    .orderDetailId(orderDetail.getIdOrderDetail())
                    .quantity(orderDetail.getQuantity())
                    /*TODO 6 : Convert product to ProductResponse*/
                            .product(ProductResponse.builder()
                                    .productId(currentProductPrice.getProduct().getIdProduct())
                                    .productName(currentProductPrice.getProduct().getName())
                                    .productDesc(currentProductPrice.getProduct().getDesc())
                                    .price(currentProductPrice.getPrice())
                                    .stock(currentProductPrice.getStock())
                    /*TODO 7 : Convert Store to Store Response (From Product Price)*/
                                    .store(StoreResponse.builder()
                                            .idStore(currentProductPrice.getStore().getIdStore())
                                            .nameStore(currentProductPrice.getStore().getName())
                                            .addressStore(currentProductPrice.getStore().getAddress())
                                    .build())
                            .build())
                    .build();
        }).collect(Collectors.toList());

        //TODO 8 : Convert store to storeResponse (from productPrice)
        CustomerResponse customerResponse = CustomerResponse.builder()
                .idCustomer(customer.getIdCustomer())
                .customerName(customer.getNameCustomer())
                .build();
        /*TODO 9 : Convert Customer to Customer Response*/
        return OrderResponse.builder()
                .orderId(order.getIdOrder())
                .customer(customerResponse)
                .transDate(order.getTransDate())
                .orderDetailResponses(orderDetailResponses)
                .build();
    }

    @Override
    public OrderResponse getOrderById(String id) {
        return null;
    }

    @Override
    public List<OrderResponse> getAllTransaction() {
        return null;
    }

}
