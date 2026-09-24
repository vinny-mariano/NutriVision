package com.nutrivision.service;

import com.nutrivision.model.Refeicao;
import com.nutrivision.repository.RefeicaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefeicaoService {

    private final RefeicaoRepository refeicaoRepository;

    // Injeção de dependência via construtor (Padrão Sênior / Spring moderno)
    public RefeicaoService(RefeicaoRepository refeicaoRepository) {
        this.refeicaoRepository = refeicaoRepository;
    }

    public List<Refeicao> listarTodas() {
        return refeicaoRepository.findAll();
    }

    public Optional<Refeicao> buscarPorId(Long id) {
        return refeicaoRepository.findById(id);
    }

    public Refeicao salvar(Refeicao refeicao) {
        // Regras de negócio adicionais podem entrar aqui
        return refeicaoRepository.save(refeicao);
    }

    public void deletar(Long id) {
        refeicaoRepository.deleteById(id);
    }
}