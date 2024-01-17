package com.enigma.buku_lapak.service.impl;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 15:00
@Last Modified 10/2/2023 15:00
Version 1.0
*/

import com.enigma.buku_lapak.config.LoggingConfig;
import com.enigma.buku_lapak.entity.Customer;
import com.enigma.buku_lapak.entity.Role;
import com.enigma.buku_lapak.entity.UserCredential;
import com.enigma.buku_lapak.entity.UserDetailImpl;
import com.enigma.buku_lapak.entity.constant.ERole;
import com.enigma.buku_lapak.model.request.AuthRequest;
import com.enigma.buku_lapak.model.request.CustomerRequest;
import com.enigma.buku_lapak.model.request.LoginRequest;
import com.enigma.buku_lapak.model.request.RegisterSellerRequest;
import com.enigma.buku_lapak.model.response.LoginResponse;
import com.enigma.buku_lapak.model.response.RegisterResponse;
import com.enigma.buku_lapak.repository.UserCredentialRepository;
import com.enigma.buku_lapak.security.BCryptUtils;
import com.enigma.buku_lapak.security.JwtUtils;
import com.enigma.buku_lapak.service.AuthService;
import com.enigma.buku_lapak.service.CustomerService;
import com.enigma.buku_lapak.service.RoleService;
import com.enigma.buku_lapak.service.ValidationService;
import com.enigma.buku_lapak.utils.LoggingFile;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ValidationService validationService;

    private String[] strExceptionArr = new String[2];

    private final UserCredentialRepository userCredentialRepository;

    private final AuthenticationManager authenticationManager;

    private final BCryptUtils bCryptUtils;

    private final CustomerService customerService;

    private final JwtUtils jwtUtils;

    private final RoleService roleService;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public RegisterResponse register(AuthRequest authRequest) {
        validationService.validate(authRequest);
        try {
            Role role = roleService.getOrSave(ERole.ROLE_CUSTOMER);
            UserCredential userCredential = UserCredential.builder()
                    .email(authRequest.getEmail())
                    .password(bCryptUtils.hashPassword(authRequest.getPassword()))
                    .roles(List.of(role))
                    .build();
            userCredentialRepository.saveAndFlush(userCredential);
            Customer customer = Customer.builder()
                    .nameCustomer(authRequest.getName())
                    .address(authRequest.getAddress())
                    .mobilePhoneCustomer(authRequest.getMobilePhone())
                    .email(authRequest.getEmail())
                    .userCredential(userCredential)
                    .build();
            customerService.create(customer);

        return RegisterResponse.builder()
                .email(userCredential.getEmail())
                .build();

        } catch (DataIntegrityViolationException e){
            strExceptionArr[0] = "AuthServiceImpl Class";
            strExceptionArr[1] = "registerNewCustomer(RegisterCustomerRequest request) --- LINE 54";
            LoggingFile.exceptionStringz(strExceptionArr, e, LoggingConfig.getFlagLogging());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Already Exist");
        }

    }

    @Override
    public RegisterResponse registerAdmin(AuthRequest authRequest) {
        return null;
    }

    @Override
    public RegisterResponse registerSeller(RegisterSellerRequest registerSellerRequest) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailImpl userDetail = (UserDetailImpl) authentication.getPrincipal();

        List<String> roles = userDetail.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        String token = jwtUtils.generateToken(userDetail.getEmail());

        return LoginResponse.builder()
                .email(userDetail.getEmail())
                .roles(roles)
                .token(token)
                .build();

    }
}
