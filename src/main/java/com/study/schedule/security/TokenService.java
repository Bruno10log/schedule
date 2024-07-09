package com.study.schedule.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.study.schedule.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generateToken(User user) {
        return JWT.create()
                .withIssuer("Schedule")
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(LocalDateTime.now().plusSeconds(30).toInstant(ZoneOffset.of("+01:00"))
                ).sign(Algorithm.HMAC256("pasteldenata"));


    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("pasteldenata"))
                .withIssuer("Schedule")
                .build().verify(token).getSubject();
    }
}
