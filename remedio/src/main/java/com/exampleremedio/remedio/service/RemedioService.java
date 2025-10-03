package com.exampleremedio.remedio.service;

import com.exampleremedio.remedio.entities.Remedio;
import com.exampleremedio.remedio.record.*;
import com.exampleremedio.remedio.repositories.RemedioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RemedioService {
    RemedioRepository remedioRepository;

    public RemedioService(RemedioRepository remedioRepository) {

        this.remedioRepository = remedioRepository;
    }
    //PostMapping
    @Transactional
    public DadosDetalhamentoSaidaDTO cadastrRemedios(DadosEntradaDTO dados){
        var remedio=remedioRepository.save(new Remedio(dados));
        return new DadosDetalhamentoSaidaDTO(remedio);
    }
    //GetMapping
    public List<DadosListagemRemediosDTO> listarRemedios(){
       return remedioRepository.findAll()
                .stream()
                .map(DadosListagemRemediosDTO::new)
                .toList();
    }
    //PutMapping
    @Transactional
    public DadosAtualizadosRemedios atualizarRemedios(@Valid DadosAtualizarRemediosDTO dados){
        var remedioAtual=remedioRepository.getReferenceById(dados.id());
        remedioAtual.atualizeRemedios(dados);
        return new DadosAtualizadosRemedios(remedioAtual);
    }
    //Delete
    public void excluir(Long id){
        remedioRepository.deleteById(id);
    }

}
