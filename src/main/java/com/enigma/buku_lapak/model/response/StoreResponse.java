package com.enigma.buku_lapak.model.response;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 9/22/2023 09:14
@Last Modified 9/22/2023 09:14
Version 1.0
*/

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StoreResponse {

    private String idStore;

    private String nameStore;

    private String addressStore;

}
