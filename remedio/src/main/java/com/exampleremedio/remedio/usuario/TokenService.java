package com.exampleremedio.remedio.usuario;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;


    public String gerarToken(String login) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("remedio")
                    .withSubject(login)
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o Token", exception);
        }
    }

    public String getSubject(String TokenJwt){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("remedio")
                    .build()
                    .verify(TokenJwt)
                    .getSubject();

        } catch (JWTVerificationException exception){
            throw  new RuntimeException("Token iválido ou expirado!");
        }
    }
      private Instant dataExpiracao() {
        return Instant.now().plusSeconds(7200); // 2 horas
    }
}
