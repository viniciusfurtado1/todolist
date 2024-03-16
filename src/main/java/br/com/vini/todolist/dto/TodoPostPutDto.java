package br.com.vini.todolist.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TodoPostPutDto(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @Min(0)
        @Max(5)
        @NotNull
        int prioridade) {
}
