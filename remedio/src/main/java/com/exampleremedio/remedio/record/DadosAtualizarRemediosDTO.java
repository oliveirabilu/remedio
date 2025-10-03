package com.exampleremedio.remedio.record;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemediosDTO(
        @NotNull
        Long id,
        String nome,
        String lote
) {
}
