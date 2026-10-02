package com.nutrivision.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

public record RefeicaoRequestDTO(
    @NotBlank(message = "A descrição da refeição não pode estar em branco.")
    String descricao,

    @NotNull(message = "As calorias são obrigatórias.")
    @Positive(message = "As calorias devem ser um valor positivo.")
    Double calorias,

    @NotNull(message = "A data e hora da refeição são obrigatórias.")
    LocalDateTime dataHora
) {}
