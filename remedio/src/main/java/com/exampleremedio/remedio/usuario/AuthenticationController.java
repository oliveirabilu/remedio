package com.exampleremedio.remedio.usuario;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DTOlogin dtOlogin){
        var token= new UsernamePasswordAuthenticationToken(dtOlogin.login(), dtOlogin.senha());
        var autenticacao= authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();

    }
}
