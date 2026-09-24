package com.nutrivision.controller;

import com.nutrivision.model.Refeicao;
import com.nutrivision.service.RefeicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/refeicoes")
public class RefeicaoController {

    private final RefeicaoService refeicaoService;

    public RefeicaoController(RefeicaoService refeicaoService) {
        this.refeicaoService = refeicaoService;
    }

    @GetMapping
    public ResponseEntity<List<Refeicao>> listarTodas() {
        List<Refeicao> refeicoes = refeicaoService.listarTodas();
        return ResponseEntity.ok(refeicoes);
    }

    @PostMapping
    public ResponseEntity<Refeicao> criar(@RequestBody Refeicao refeicao) {
        Refeicao novaRefeicao = refeicaoService.salvar(refeicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaRefeicao);
    }
}