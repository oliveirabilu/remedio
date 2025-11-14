package com.exampleremedio.remedio.controller;

import com.exampleremedio.remedio.record.*;
import com.exampleremedio.remedio.service.RemedioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {
    RemedioService remedioService;

    public RemedioController(RemedioService remedioService) {
        this.remedioService = remedioService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoSaidaDTO> cadastrar(@RequestBody @Valid DadosEntradaDTO dados,
                                                               UriComponentsBuilder uriBuilder){
     var remedio=remedioService.cadastrRemedios(dados);
     var uri= uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.id()).toUri();
     return ResponseEntity.created(uri).body(remedio);

    }
    @GetMapping
   public ResponseEntity<List<DadosListagemRemediosDTO>> listar(){
        var lista=remedioService.listarRemedios();
        return ResponseEntity.ok(lista);
    }
    @PutMapping
    public ResponseEntity<DadosAtualizadosRemedios> atualizar(@RequestBody @Valid DadosAtualizarRemediosDTO dados){
        remedioService.atualizarRemedios(dados);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        remedioService.excluir(id);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/inativar/{id}")
    public void inativar(@PathVariable Long id){
        remedioService.inativar(id);
    }
    @PutMapping("/reativar/{id}")
    public void ativar(@PathVariable Long id){
        remedioService.ativar(id);
    }

}
