package com.example.devinhousemodulo_2_projeto_avaliativo_2.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Service
public class TokenServicePersonalizado {
    @Value("${security.jwt.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        return JWT.create().withIssuer("Security JWT")
                .withSubject(usuario.getNome())
                .withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now().plusMinutes(10).toInstant(ZonedDateTime.now().getOffset())) // ou ZoneOffset.of("-03:00")
                .sign(Algorithm.HMAC256(secret));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("Security JWT")
                .build()
                .verify(token)
                .getSubject();
    }
}
