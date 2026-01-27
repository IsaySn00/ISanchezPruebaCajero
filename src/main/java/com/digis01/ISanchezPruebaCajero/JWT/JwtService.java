package com.digis01.ISanchezPruebaCajero.JWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final String SECRET = "CjntvvFoDwVAHfVJvMM0BrVtwSGrLmwOfF0HzCjc8Yt";

    public String generateToken(Authentication auth) {
        return Jwts.builder()
                .setSubject(auth.getName())
                .claim("roles", auth.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}
