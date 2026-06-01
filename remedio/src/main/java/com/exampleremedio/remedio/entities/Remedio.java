package com.exampleremedio.remedio.entities;
import com.exampleremedio.remedio.ennumm.Laboratorio;
import com.exampleremedio.remedio.ennumm.Via;
import com.exampleremedio.remedio.record.DadosAtualizarRemediosDTO;
import com.exampleremedio.remedio.record.DadosEntradaDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
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
    private Boolean ativo;

    public Remedio() {
    }

    public Remedio(DadosEntradaDTO dados) {
        this.nome= dados.nome();
        this.via=dados.via();
        this.lote= dados.lote();
        this.quantidade=dados.quantidade();
        this.validade=dados.validade();
        this.laboratorio=dados.laboratorio();
        this.ativo=true;
    }

    public void atualizeRemedios(DadosAtualizarRemediosDTO dados){
        if (dados.nome()!=null){
            this.nome= dados.nome();
        }
        if (dados.lote()!=null){
            this.lote= dados.lote();
        }
    }

    public void inativar() {
        this.ativo=false;
    }

    public void ativar() {
        this.ativo=true;
    }
}