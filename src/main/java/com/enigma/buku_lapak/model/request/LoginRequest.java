package com.enigma.buku_lapak.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

}

