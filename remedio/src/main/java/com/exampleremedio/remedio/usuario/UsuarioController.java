package com.exampleremedio.remedio.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final AuthenticationService authenticationService;

    public UsuarioController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping
    public ResponseEntity<UsuarioDTOsaida> criar(@RequestBody Usuario user) {
        Usuario salvo=authenticationService.salvar(user);
        return ResponseEntity.ok(new UsuarioDTOsaida(salvo.getId(), salvo.getLogin()));
    }
}
