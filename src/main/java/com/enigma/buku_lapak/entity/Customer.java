package com.enigma.buku_lapak.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/22/2023 15:21
@Last Modified 9/22/2023 15:21
Version 1.0
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_Customer")
public class Customer {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_customer")
    private String idCustomer;

    @Column(name = "customer_name", nullable = false)
    private String nameCustomer;

    @Column(name = "customer_address", nullable = false)
    private String address;

    @Column(name = "customer_mobile_phone", nullable = false, unique = true)
    private String mobilePhoneCustomer;

    @Column(name = "customer_email", nullable = false, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "id_user_credential")
    private UserCredential userCredential;

}
