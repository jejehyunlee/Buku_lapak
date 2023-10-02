package com.enigma.buku_lapak.security;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 14:37
@Last Modified 10/2/2023 14:37
Version 1.0
*/

import com.enigma.buku_lapak.model.response.CommonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@RequiredArgsConstructor
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        CommonResponse<Object> commonResponse = CommonResponse.builder()
                .httpStatus(HttpStatus.FORBIDDEN)
                .statusCode(HttpStatus.FORBIDDEN.value())
                .message(accessDeniedException.getMessage())
                .build();

        String strCommonResponse = objectMapper.writeValueAsString(commonResponse);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(strCommonResponse);
    }
}
