package com.enigma.buku_lapak.repository;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 13:22
@Last Modified 10/2/2023 13:22
Version 1.0
*/


import com.enigma.buku_lapak.entity.Role;
import com.enigma.buku_lapak.entity.constant.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {


    Optional<Role> findByRole(ERole role);

}
