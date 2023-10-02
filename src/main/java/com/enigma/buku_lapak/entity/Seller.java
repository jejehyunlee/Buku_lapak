package com.enigma.buku_lapak.entity;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 11:11
@Last Modified 10/2/2023 11:11
Version 1.0
*/


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_seller")
public class Seller {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_seller")
    private String idSeller;

    private String username;

    @OneToOne
    @JoinColumn(name = "id_user_credential")
    private UserCredential userCredential;

    @OneToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    @JoinColumn(name = "id_store")
    private Store store;

}
