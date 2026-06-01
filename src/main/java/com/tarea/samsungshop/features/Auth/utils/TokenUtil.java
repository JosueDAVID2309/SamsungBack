package com.tarea.samsungshop.features.Auth.utils;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.tarea.samsungshop.features.Auth.properties.JwtProperties;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class TokenUtil {

    @Autowired
    JwtProperties jwtProperties;

    public String generateAccessToken(String correo){
        return Jwts.builder()
            .setSubject(correo)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getAccessTokenExpiration()))
            .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
            .compact();
    }

    public String generateRefreshToken(String correo){
        return Jwts.builder()
            .setSubject(correo)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getRefreshTokenExpiration()))
            .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
            .compact();
    }
}
