package com.exampleremedio.remedio.controller;

import com.exampleremedio.remedio.record.*;
import com.exampleremedio.remedio.service.RemedioService;
import com.exampleremedio.remedio.usuario.SecurityConfiguration;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/remedios")
@Tag(name = "/remedios", description = "Controlador de Remedios e Laboratorios, e editar dados")
@SecurityRequirement(name = SecurityConfiguration.SECURITY)
public class RemedioController {
    RemedioService remedioService;


    public RemedioController(RemedioService remedioService) {
        this.remedioService = remedioService;
    }

    @PostMapping
    @Operation(summary = "Cadastra/Cria os remedios e determina o endereço Uri", description = "Metodo para cadastrar/criar Remedios")
    @ApiResponse(responseCode = "201", description = "Remedio criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request - Não conseguiu entender ou processar a requisição")
    @ApiResponse(responseCode = "500", description = "Erro Servidor - falha lado servidor")
    public ResponseEntity<DadosDetalhamentoSaidaDTO> cadastrar(@RequestBody @Valid DadosEntradaDTO dados,
                                                               UriComponentsBuilder uriBuilder){
     var remedio=remedioService.cadastrRemedios(dados);
     var uri= uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.id()).toUri();
     return ResponseEntity.created(uri).body(remedio);

    }
    @GetMapping
    @Operation(summary = "Busca Dados dos remedios", description = "Metodo para Buscar dados dos Remedios")
    @ApiResponse(responseCode = "200", description = "Busca efetuada com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request - Não conseguiu entender ou processar a requisição")
    @ApiResponse(responseCode = "500", description = "Erro Servidor - falha lado servidor")
   public ResponseEntity<List<DadosListagemRemediosDTO>> listar(){
        var lista=remedioService.listarRemedios();
        return ResponseEntity.ok(lista);
    }
    @PutMapping
    @Operation(summary = "Atualiza os Dados dos remedios por Id", description = "Metodo para Atualizar dados dos Remedios")
    @ApiResponse(responseCode = "200", description = "Atualizado os dados com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request - Não conseguiu entender ou processar a requisição")
    @ApiResponse(responseCode = "500", description = "Erro Servidor - falha lado servidor")
    public ResponseEntity<DadosAtualizadosRemedios> atualizar(@RequestBody @Valid DadosAtualizarRemediosDTO dados){
        remedioService.atualizarRemedios(dados);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Apaga Dados dos remedios por Id", description = "Metodo para Apagar dados dos Remedios")
    @ApiResponse(responseCode = "200", description = "Delete efetuado com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request - Não conseguiu entender ou processar a requisição")
    @ApiResponse(responseCode = "500", description = "Erro Servidor - falha lado servidor")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        remedioService.excluir(id);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("/inativar/{id}")
    @Operation(summary = "Desativa temporariamente Dados dos remedios por Id", description = "Metodo para Desativar temporariamente  dados dos Remedios")
    @ApiResponse(responseCode = "200", description = "Desativado temporariamente os dados com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request - Não conseguiu entender ou processar a requisição")
    @ApiResponse(responseCode = "500", description = "Erro Servidor - falha lado servidor")
    public void inativar(@PathVariable Long id){

        remedioService.inativar(id);
    }
    @PutMapping("/reativar/{id}")
    @Operation(summary = "Reativa novamente os Dados dos remedios por Id", description = "Metodo para Reativar os dados dos Remedios")
    @ApiResponse(responseCode = "200", description = "Reativado os dados novamente com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request - Não conseguiu entender ou processar a requisição")
    @ApiResponse(responseCode = "500", description = "Erro Servidor - falha lado servidor")
    public void ativar(@PathVariable Long id){

        remedioService.ativar(id);
    }

}
