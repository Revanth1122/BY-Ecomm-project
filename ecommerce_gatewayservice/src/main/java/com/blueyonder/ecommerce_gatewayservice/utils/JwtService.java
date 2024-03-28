package com.blueyonder.ecommerce_gatewayservice.utils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {


    public static final String SECRET = "BLUEYONDERBELLANDURBENGALURUBLUEYONDERBELLANDURBENGALURUBLUEYONDERBELLANDURBENGALURUBENGALURUBLUEYONDERBELLANDURBENGALURUBENGALURUBLUEYONDERBELLANDURBENGALURU";


    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}