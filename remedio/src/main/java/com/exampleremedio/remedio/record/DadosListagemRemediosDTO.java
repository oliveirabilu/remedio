package com.exampleremedio.remedio.record;

import com.exampleremedio.remedio.ennumm.Laboratorio;
import com.exampleremedio.remedio.ennumm.Via;
import com.exampleremedio.remedio.entities.Remedio;

import java.time.LocalDate;

public record DadosListagemRemediosDTO(
        Boolean ativo,
        Long id,
        String nome,
        Via via,
        String lote,
        Integer quantidade,
        LocalDate validade,
        Laboratorio laboratorio
) {
    public DadosListagemRemediosDTO(Remedio remedio){
        this(remedio.getAtivo(),
                remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio());
    }
}
