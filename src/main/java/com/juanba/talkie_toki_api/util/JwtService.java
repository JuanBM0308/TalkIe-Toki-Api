package com.juanba.talkie_toki_api.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.juanba.talkie_toki_api.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

@Service
public class JwtService {

    @Value("${talkie.security.oauth0.jwt.secret-key}")
    private String SECRET_KEY;

    public String generateToken(User user) {
        var algorithm = Algorithm.HMAC256(SECRET_KEY);
        return JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withIssuer("talkie-toki-api")
                .withSubject(user.getUsername())
                .withClaim("roles", List.of(user.getRole().name()))
                .withIssuedAt(issueDate())
                .withExpiresAt(expirationDate())
                .sign(algorithm);
    }

    private Instant issueDate() {
        return LocalDateTime.now().toInstant(ZoneOffset.of("-05:00"));
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-05:00"));
    }

    public String getSubject(String token) {
        try {
            var algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.require(algorithm)
                    .withIssuer("talkie-toki-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Invalid JWT or expired");
        }
    }
}
