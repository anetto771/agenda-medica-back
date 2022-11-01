package com.api.agendamedicaback.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component

public class JWTUtil {
    @Value("${jwt.expiration}")
    private String secret;
    @Value("${jwt.secret}")

    private Long expiration;
    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis()+ expiration))
                .signWith(SignatureAlgorithm.ES512, secret.getBytes())
                .compact();
    }

}
