package com.enigma.buku_lapak.entity;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/20/2023 16:46
@Last Modified 9/20/2023 16:46
Version 1.0
*/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "m_store")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Store {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_store")
    private String idStore;

    @Column(name = "no_siup",
            nullable = false,
            unique = true)
    private String noSiup;

    @Column(name = "name",
            nullable = false)
    private String name;

    @Column(name = "address",
            nullable = false)
    private String address;

    @Column(name = "no_hp",
            nullable = false,
            unique = true)
    private String mobilePhone;

}

