package com.exampleremedio.remedio.entities;
import com.exampleremedio.remedio.ennumm.Laboratorio;
import com.exampleremedio.remedio.ennumm.Via;
import com.exampleremedio.remedio.record.DadosAtualizarRemediosDTO;
import com.exampleremedio.remedio.record.DadosEntradaDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="TB_REMEDIO")
public class Remedio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private Integer quantidade;
    private LocalDate validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    public Remedio() {
    }

    public Remedio(DadosEntradaDTO dados) {
        this.nome= dados.nome();
        this.via=dados.via();
        this.lote= dados.lote();
        this.quantidade=dados.quantidade();
        this.validade=dados.validade();
        this.laboratorio=dados.laboratorio();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Via getVia() {
        return via;
    }
    public void setVia(Via via) {
        this.via = via;
    }
    public String getLote() {
        return lote;
    }
    public void setLote(String lote) {
        this.lote = lote;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public LocalDate getValidade() {
        return validade;
    }
    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
    public Laboratorio getLaboratorio() {
        return laboratorio;
    }
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }


    public void atualizeRemedios(DadosAtualizarRemediosDTO dados){
        if (dados.nome()!=null){
            this.nome= dados.nome();
        }
        if (dados.lote()!=null){
            this.lote= dados.lote();
        }
    }
}