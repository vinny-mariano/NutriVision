package com.nutrivision.service;

import com.nutrivision.dto.RefeicaoRequestDTO;
import com.nutrivision.dto.RefeicaoResponseDTO;
import com.nutrivision.model.Refeicao;
import com.nutrivision.repository.RefeicaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RefeicaoService {

    private final RefeicaoRepository repository;

    public RefeicaoService(RefeicaoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public RefeicaoResponseDTO criar(RefeicaoRequestDTO dto) {
        Refeicao refeicao = new Refeicao();
        refeicao.setDescricao(dto.descricao());
        refeicao.setCalorias(dto.calorias());
        refeicao.setDataHora(dto.dataHora());

        Refeicao salva = repository.save(refeicao);
        return new RefeicaoResponseDTO(salva);
    }

    @Transactional(readOnly = true)
    public List<RefeicaoResponseDTO> listarTodas() {
        return repository.findAll().stream()
                .map(RefeicaoResponseDTO::new)
                .collect(Collectors.toList());
    }
}
