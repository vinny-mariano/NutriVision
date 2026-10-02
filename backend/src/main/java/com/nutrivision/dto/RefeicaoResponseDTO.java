package com.nutrivision.dto;

import com.nutrivision.model.Refeicao;
import java.time.LocalDateTime;

public record RefeicaoResponseDTO(
    Long id,
    String descricao,
    Double calorias,
    LocalDateTime dataHora
) {
    public RefeicaoResponseDTO(Refeicao refeicao) {
        this(refeicao.getId(), refeicao.getDescricao(), refeicao.getCalorias(), refeicao.getDataHora());
    }
}
