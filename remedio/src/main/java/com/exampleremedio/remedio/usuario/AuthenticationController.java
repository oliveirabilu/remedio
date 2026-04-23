package com.exampleremedio.remedio.usuario;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    public AuthenticationController(AuthenticationManager manager) {
        this.manager = manager;
    }

    private final AuthenticationManager manager;
    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DTOlogin dtOlogin){
        var token= new UsernamePasswordAuthenticationToken(dtOlogin.login(), dtOlogin.senha());
        var autenticacao= manager.authenticate(token);
        return ResponseEntity.ok().build();

    }
}
