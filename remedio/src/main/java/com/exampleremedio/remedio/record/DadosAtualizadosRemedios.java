package com.exampleremedio.remedio.record;

import com.exampleremedio.remedio.ennumm.Laboratorio;
import com.exampleremedio.remedio.ennumm.Via;
import com.exampleremedio.remedio.entities.Remedio;

import java.time.LocalDate;

public record DadosAtualizadosRemedios(
        Long id,
        String nome,
        Via via,
        String lote,
        Integer quantidade,
        LocalDate validade,
        Laboratorio laboratorio
) {
    public DadosAtualizadosRemedios(Remedio remedioAtual) {
        this(remedioAtual.getId(),
                remedioAtual.getNome(),
                remedioAtual.getVia(),
                remedioAtual.getLote(),
                remedioAtual.getQuantidade(),
                remedioAtual.getValidade(),
                remedioAtual.getLaboratorio());
    }
}
