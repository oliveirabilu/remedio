package com.exampleremedio.remedio.record;

import com.exampleremedio.remedio.ennumm.Laboratorio;
import com.exampleremedio.remedio.ennumm.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosEntradaDTO(
        @NotBlank
        String nome,
        @Enumerated
        Via via,
        @NotBlank
        String lote,
        Integer quantidade,
        @Future
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio
) {
}
