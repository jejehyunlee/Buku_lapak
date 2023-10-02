package com.enigma.buku_lapak.security;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/2/2023 13:53
@Last Modified 10/2/2023 13:53
Version 1.0
*/

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtUtils {

    @Value("${bukulapak.jwt.secret}")
    private String jwtSecret;
    @Value("${bukulapak.jwt.expiration}")
    private Long jwtExpired;

    public String getEmailByToken(String token){

        return Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(token).getBody().getSubject();
    }

    public String generateToken (String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .setExpiration(new Date(System.currentTimeMillis()+ jwtExpired))
                .compact();

    }

    public boolean validateJwtToken(String token){

        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
                }catch (MalformedJwtException jwtException){
                    log.error(jwtException.getMessage() , "JWT Invalid Token {}");
                }catch (ExpiredJwtException expiredJwtException){
                    log.error(expiredJwtException.getMessage() , "JWT Is Expired {}");
                }catch (UnsupportedJwtException unsupportedJwtException){
                    log.error(unsupportedJwtException.getMessage() , "JWT Is Unsupport {}");
                }catch (IllegalArgumentException illegalArgumentException){
                    log.error(illegalArgumentException.getMessage() , "JWT Claims is Empty {}");
                }
        return false;
    }

}
